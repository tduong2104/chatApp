package com.doan.chatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

public class SearchUser extends AppCompatActivity {

    EditText searchInput;
    ImageButton searchBtn;
    ImageButton backBtn;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);

        searchInput = findViewById(R.id.search_username_input);
        searchBtn = findViewById(R.id.search_user_btn);
        backBtn = findViewById(R.id.back_btn);
        recyclerView = findViewById(R.id.search_user_recycleView);

        searchInput.requestFocus();

        backBtn.setOnClickListener(v -> {
            getOnBackPressedDispatcher();
        });

        searchBtn.setOnClickListener(v -> {
            String searchTerm = searchInput.getText().toString();
            if (searchTerm.isEmpty()){
                searchInput.setError("Invalid Username");
                return;
            }
            setupSearchRecycleView(searchTerm);
        });
    }

    void setupSearchRecycleView(String searchTerm){

    }
}