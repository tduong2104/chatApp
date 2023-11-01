package com.doan.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.hbb20.CountryCodePicker;

public class Login extends AppCompatActivity {

    CountryCodePicker countryCodePicker;
    EditText phone_num;
    Button  sendOTP;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        countryCodePicker = findViewById(R.id.login_countrycode);
        phone_num = findViewById(R.id.login_mobile_number);
        sendOTP = findViewById(R.id.send_otp_btn);
        progressBar = findViewById(R.id.login_progress_bar);

        progressBar.setVisibility(View.GONE);

        countryCodePicker.registerCarrierNumberEditText(phone_num);
        sendOTP.setOnClickListener((v) -> {
            if(!countryCodePicker.isValidFullNumber()){
                phone_num.setError("Phone number not valid");
                return;
            }
            Intent intent = new Intent(Login.this, Login_otp.class);
            intent.putExtra("phone", countryCodePicker.getFullNumberWithPlus());
            startActivity(intent);
        });
    }
}