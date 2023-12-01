package com.example.myemergentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.myemergentapplication.databinding.ActivityServicePersonpBinding;

public class ServicePersonp extends AppCompatActivity  {
ActivityServicePersonpBinding binding;
TextView t1,t2,t3,t4,t5;
    DataHelper dh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_personp);
        binding=ActivityServicePersonpBinding.inflate(getLayoutInflater());

        t1=binding.t1;
        t2=binding.t2;
        t3=binding.t3;
        t4=binding.t4;
        t5=binding.t5;
        dh=new DataHelper(this);//puttext();
        Button show=binding.showbtn;
        show.setOnClickListener(view -> {
            puttext();
        });
      //  t1.setText(dh.getserviceprovider());
       /* DataHelper dh=new DataHelper(getBaseContext());
        Cursor c=dh.getserviceprovider();
        t1.setText(c.getString(0));*/


        //t1.setText(getIntent().getStringExtra("qwer"));
    }
private void puttext()
{
    String name=(dh.retrive());
    t1.setText(name);
    t2.setText("navee");
}

}