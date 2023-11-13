package com.doan.chatapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.doan.chatapp.utils.FirebaseUtil;

public class ProfileFragment extends Fragment {

    ImageButton logoutBtn;
    ImageButton backBtn;
    public ProfileFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_profiles, container, false);

        logoutBtn = view.findViewById(R.id.logout_btn);

        logoutBtn.setOnClickListener(v -> {
            FirebaseUtil.logout();
            Intent intent = new Intent(getContext(),SplashScreen.class);

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        return view;
    }


}