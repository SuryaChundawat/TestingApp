package com.example.admin.testingapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.admin.testingapp.R.id.icon;
import static com.example.admin.testingapp.R.id.time;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "RecyclerViewExample";
    public List<DataObject> feedsList;
    private RecyclerView mRecyclerView;
    Button b1;
   // private MyRecyclerAdapter adapter;
    private ProgressBar progressBar;
    // Downloading data from below url
    final String url = "http://stacktips.com/?json=get_recent_posts&count=45";
    private CharSequence text="Surya Narayan Singh Chundawat";
    private CharSequence title="I achived noificaton";
    private int NOTIFICATION =1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notify("You've received new message","");
            }
        });

    }

    public void Notify(String notificationTitle, String notificationMessage)
    {
        NotificationManager notificationManager =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new Notification(R.mipmap.dpq,"New Message",System.currentTimeMillis());
        Intent notificationIntent   = new Intent(this,NotificationView.class);
        PendingIntent pendingIntent =PendingIntent.getActivity(this,0,notificationIntent, 0);
        /*if (currentapiVersion < android.os.Build.VERSION_CODES.HONEYCOMB) {
            notification.setLatestEventInfo(MainActivity.this, notificationTitle, notificationMessage, pendingIntent);
            notification.flags |= Notification.FLAG_AUTO_CANCEL;
            notificationManager.notify(9999, notification);
        }else {*/
            NotificationCompat.Builder builder = new NotificationCompat.Builder(
                    this);
            notification = builder.setContentIntent(pendingIntent)
                    .setSmallIcon(icon).setTicker(text).setWhen(time)
                    .setAutoCancel(true).setContentTitle(title)
                    .setContentText(text).build();
            notificationManager.notify(NOTIFICATION, notification);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        return super.onCreateOptionsMenu(menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
    }

}
