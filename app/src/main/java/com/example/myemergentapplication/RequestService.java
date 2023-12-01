package com.example.myemergentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.myemergentapplication.databinding.ActivityRequestServiceBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RequestService extends AppCompatActivity {

EditText name,loc,contact,date,time;
Button book;
String rname,rloc,rcontact,rdate,rtime;
DataHelper dh;
BookingHelper bh;
FirebaseDatabase db;
DatabaseReference reference;
ActivityRequestServiceBinding activityRequestServiceBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_service);
        activityRequestServiceBinding=ActivityRequestServiceBinding.inflate(getLayoutInflater());
        //*************************************************
        name=activityRequestServiceBinding.d1;
        loc=activityRequestServiceBinding.d3;
        contact=activityRequestServiceBinding.d2;
        date=activityRequestServiceBinding.d4;
        time=activityRequestServiceBinding.d5;

        dh=new DataHelper(this);
        bh=new BookingHelper(this);
        //******************************************************
        book=activityRequestServiceBinding.bookbtn;
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=FirebaseDatabase.getInstance();
                reference= db.getReference("profiles");

                Toast.makeText(RequestService.this, "booked", Toast.LENGTH_SHORT).show();
                              /* rname=name.getText().toString();
                rloc=loc.getText().toString();
                rcontact=contact.getText().toString();
                rdate=date.getText().toString();
                rtime=time.getText().toString();
                boolean res=bh.insertbooking(rname,rcontact,rloc,rdate,rtime);
                if(res==true) Toast.makeText(RequestService.this, "booked", Toast.LENGTH_SHORT).show();
                else Toast.makeText(RequestService.this, "error", Toast.LENGTH_SHORT).show();*/
            }
        });
    }


}