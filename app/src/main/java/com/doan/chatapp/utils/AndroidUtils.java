package com.doan.chatapp.utils;

import android.widget.Toast;

import android.content.Context;

public class AndroidUtils {
    public static void showToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
