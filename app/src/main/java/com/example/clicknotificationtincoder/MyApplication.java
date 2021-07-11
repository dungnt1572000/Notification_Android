package com.example.clicknotificationtincoder;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

public class MyApplication extends Application {
    public static final String CHANNEL_ID = "CHANEL_1";
    public static final String CHANNEL_ID2 = "CHANEL_2";
    private static final String TITLE_PUSH_NOTIFICATION = "DAY LA TITLE NOTIFICATION";
    private static final String CONTENT_PUSH_NOTIFICATION = "Creating an existing notification channel with its original values performs no operation, so it's safe to call this code when starting an app.";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            AudioAttributes audioAttributes = new Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION).build();
            //config chanel1
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            channel.setSound(uri,audioAttributes);
            //config chanel2
            CharSequence name2 = getString(R.string.channel_name2);
            String description2 = getString(R.string.channel_description2);
            int importance2 = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel2 = new NotificationChannel(CHANNEL_ID2, name2, importance2);
            channel2.setDescription(description2);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
            notificationManager.createNotificationChannel(channel2);
        }
    }
}
