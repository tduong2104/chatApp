package com.doan.chatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import com.doan.chatapp.Adapter.SearchUserRecycleAdapter;
import com.doan.chatapp.Models.UserModel;
import com.doan.chatapp.utils.Firebase;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class SearchUser extends AppCompatActivity {

    EditText searchInput;
    ImageButton searchBtn;
    ImageButton backBtn;
    RecyclerView recyclerView;

    SearchUserRecycleAdapter adapter;
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
            onBackPressed();
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
        Query query = Firebase.allUserCollectionReference()
                .whereGreaterThanOrEqualTo("username", searchTerm);
        FirestoreRecyclerOptions<UserModel> options = new FirestoreRecyclerOptions.Builder<UserModel>()
                .setQuery(query,UserModel.class).build();
        adapter = new SearchUserRecycleAdapter(options,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.startListening();
    }
    @Override
    protected void onStart() {
        super.onStart();
        if (adapter != null)
            adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (adapter != null)
            adapter.stopListening();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adapter != null)
            adapter.startListening();
    }
}