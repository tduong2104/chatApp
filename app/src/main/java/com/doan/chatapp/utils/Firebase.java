package com.doan.chatapp.utils;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.auth.FirebaseAuthException;

public class Firebase {

    public static String currentUserId(){
        return "";
    }
    public static boolean isLoggedIn(){
        if (currentUserId() != null){
            return true;
        }
        return false;
    }
    public static DocumentReference currentUserDetail(){
        return FirebaseFirestore.getInstance().collection("users").document();
    }

    public static CollectionReference allUserCollectionReference(){
        return FirebaseFirestore.getInstance().collection("users");
    }
}
