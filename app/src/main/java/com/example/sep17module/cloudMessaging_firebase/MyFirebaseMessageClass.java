package com.example.sep17module.cloudMessaging_firebase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.iid.FirebaseInstanceIdReceiver;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessageClass extends FirebaseMessagingService {

    // service  // background task

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
        Log.i("token",s);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.i("message",remoteMessage.getNotification().getBody());
    }
}
