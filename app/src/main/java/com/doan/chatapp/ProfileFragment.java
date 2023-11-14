package com.doan.chatapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.doan.chatapp.utils.FirebaseUtil;

public class ProfileFragment extends AppCompatActivity {

    ImageButton logoutBtn;
    ImageButton backBtn;
    public ProfileFragment() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profiles);

        logoutBtn = findViewById(R.id.logout_btn);
        backBtn = findViewById(R.id.profile_back_btn);

        logoutBtn.setOnClickListener(v -> {
            FirebaseUtil.logout();
            Intent intent = new Intent(this,SplashScreen.class);

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


}