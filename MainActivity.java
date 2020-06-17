package com.example.babyincar;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth mAuth;
    DatabaseReference reff;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.ma_button).setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        reff = FirebaseDatabase.getInstance().getReference().child("Clicks");

        notificationManager = NotificationManagerCompat.from(this);
    }

    public void onClick(View view) {

        switch (view.getId()){

            case R.id.ma_button:
                startActivity(new Intent(this, AlertActivity.class));
                break;
            default:

        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void sendNotification() {
        Notification notification = new NotificationCompat.Builder(this, App.CHANNEL).
                setSmallIcon(R.drawable.ic_android_black_24dp).setContentTitle("allert").setContentText("kids in the car").
                setPriority(NotificationCompat.PRIORITY_HIGH).setCategory(NotificationCompat.CATEGORY_MESSAGE).build();
        notificationManager.notify(1, notification);
    }
}
