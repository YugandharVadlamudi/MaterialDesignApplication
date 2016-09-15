package com.compindia.firebasepushnotificationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.compindia.firebasepushnotificationapp.services.MyFirebaseMessagingService;

public class FireBasePushNotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_base_push_notification);
        startService(new Intent(this, MyFirebaseMessagingService.class));
    }
}
