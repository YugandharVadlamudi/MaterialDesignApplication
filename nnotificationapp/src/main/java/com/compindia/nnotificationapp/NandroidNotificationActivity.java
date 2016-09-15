package com.compindia.nnotificationapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class NandroidNotificationActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btNandroidNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nandroid_notification);
        setUpVIews();
    }

    private void setUpVIews() {
        btNandroidNotification = (Button) findViewById(R.id.bt_n_notification);
        btNandroidNotification.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_n_notification:
                buildReplyNotification();
                break;
        }

    }

    private void buildReplyNotification() {
        RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.layout_notification);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setTicker("customNotification");
        builder.setSmallIcon(R.drawable.ic_notification_64);
        Notification notification = builder.build();
        notification.contentView = contentView;
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1,notification);

/*
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT_WATCH) {
            RemoteInput remoteInput =
                    new RemoteInput.Builder(getString(R.string.NandroidNotification_userkey))
                            .setLabel(getString(R.string.lable_NandroidNotifiation_remoteinput))
                            .build();
            Notification.Action action =
                    new Notification.Action.Builder(R.drawable.ic_notification_64
                            , "Title notifiction"
                            , null)
                            .addRemoteInput(remoteInput)
                            .build();
            Notification buildNotification =
                    new Notification.Builder(getApplicationContext())
                            .setContentTitle("ContextTitle")
                            .setContentText("ContextText")
                            .setSmallIcon(R.drawable.ic_notification_64)
                            .build();

            NotificationManagerCompat nManager
                    = NotificationManagerCompat.from(getApplicationContext());
            nManager.notify(1,buildNotification);
        }
*/
    }

    private PendingIntent bulidPendingIntent() {

        return null;
    }

}



