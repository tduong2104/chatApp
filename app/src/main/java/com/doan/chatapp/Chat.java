package com.doan.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class Chat extends AppCompatActivity {
    ImageButton backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        backBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Chat.this, MainActivity.class);
            startActivity(intent);
        });
    }
}