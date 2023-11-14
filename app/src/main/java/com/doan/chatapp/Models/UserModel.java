package com.doan.chatapp.Models;


import com.google.firebase.Timestamp;

public class UserModel {
    private String phoneNumber;
    private String username;
    private Timestamp createdTimestamp;
    private String userId;
    private String fcmToken;

    public UserModel() {
    }

    public UserModel(String phoneNumber, String username, Timestamp createdTimestamp) {
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.createdTimestamp = createdTimestamp;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public void setPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }
}
