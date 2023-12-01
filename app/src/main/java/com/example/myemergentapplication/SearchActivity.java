package com.example.myemergentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        TextView textView=findViewById(R.id.textView2);
        Animation animation=AnimationUtils.loadAnimation(this,R.anim.blink);
        textView.startAnimation(animation);
    }
}