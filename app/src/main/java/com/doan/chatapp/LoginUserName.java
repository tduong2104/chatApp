package com.doan.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.doan.chatapp.Models.UserModel;
import com.doan.chatapp.utils.FirebaseUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;


public class LoginUserName extends AppCompatActivity {

    EditText usernameInput;
    Button loginBtn;
    String phoneNumber;
    UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user_name);

        usernameInput = findViewById(R.id.login_username);
        loginBtn = findViewById(R.id.login_btn);

        phoneNumber = getIntent().getExtras().getString("phone");
        getUsername();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUsername();
            }
        });
    }

    void getUsername(){
        FirebaseUtil.currentUserDetails().get().addOnCompleteListener(task -> {
           if(task.isSuccessful()){
                userModel = task.getResult().toObject(UserModel.class);
                if(userModel != null){
                    usernameInput.setText(userModel.getUsername());
                }
           }
        });
    }

    void setUsername(){
        String username = usernameInput.getText().toString();
        if (username.isEmpty()||username.length()<2){
            usernameInput.setError("Username length should be at least 2 chars");
            return;
        }

        if (userModel != null){
            userModel.setUsername(username);
        }
        else {
            userModel = new UserModel(phoneNumber, username, Timestamp.now());
        }
        FirebaseUtil.currentUserDetails().set(userModel).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(LoginUserName.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
            }
        });
    }

}