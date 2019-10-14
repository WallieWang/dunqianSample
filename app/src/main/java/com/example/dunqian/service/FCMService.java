package com.example.dunqian.service;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FCMService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.e("FCMService", "message:"+ remoteMessage.getData().get("show_this"));
    }

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
    }
}
