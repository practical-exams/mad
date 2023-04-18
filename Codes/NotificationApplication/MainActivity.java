package com.example.notificationapplication;
import android.os.Bundle;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void sendNotification(View view) {

        //Get an instance of NotificationManager//

        NotificationCompat.Builder mBuilder =  new NotificationCompat.Builder(this)
            .setSmallIcon(R.drawable.ic_launcher)
            .setContentTitle("My notification")
            .setContentText("Hello World!");
        // Gets an instance of the NotificationManager service//
        NotificationManager mNotificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
       // NotificationManager.notify().
        mNotificationManager.notify(001, mBuilder.build());
	}
}
