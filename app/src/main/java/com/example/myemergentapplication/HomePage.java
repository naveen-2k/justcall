package com.example.myemergentapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class HomePage extends AppCompatActivity
{
    FirebaseAuth auth;
    DataHelper mydb;
    BottomNavigationView navigationView;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user= auth.getCurrentUser();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        mydb=new DataHelper(this);
        auth=FirebaseAuth.getInstance();
        String na=auth.getCurrentUser().toString();

//broadcast receiver*************************************
        IntentFilter filter=new IntentFilter("android.intent.action.AIRPLANE_MODE");
        MyReceiver receiver=new MyReceiver();
        registerReceiver(receiver,filter);
//******************************************************


//fragment attach***********************************
        TopBar topBar=new TopBar();
        home_fragment hf=new home_fragment();

        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.frameLayout2,hf);
        transaction.add(R.id.frameLayout3,topBar);
        transaction.commit();
//*****************************************************************


        navigationView = findViewById(R.id.navibar);
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout2,new home_fragment()).commit();
                        break;
                    case R.id.notification:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout2,new home_fragment()).commit();
                        break;
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout2,new ProfileFragment()).addToBackStack(null).commit();
                        break;
                }
                return  true;
            }
        });

//song service***********************************************
        startService(new Intent(this,MyService.class));
//**************************************************************



//************************************************************
       /* if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel=new NotificationChannel("my notification","my notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager nmanager=getSystemService(NotificationManager.class);
            nmanager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"channel")
                .setContentTitle("Service")
                .setSmallIcon(R.drawable.logoo)
                .setContentText("notify")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);
        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1,builder.build());*/
//************************************************************************






    }


}