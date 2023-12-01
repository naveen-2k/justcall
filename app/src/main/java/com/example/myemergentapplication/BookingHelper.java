package com.example.myemergentapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BookingHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME="Emer.db";
    public static final String TABLE_NAME="bookings";
    public static final String COL_1="bname";
    public static final String COL_2="servicename";
    public static final String COL_3="contact";
    public static final String COL_4="location";
    public static final String COL_5="dates";
    public static final String COL_6="times";
    public BookingHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table "+TABLE_NAME+" (bname varchar(20),servicename varchar(20),contact varchar(20),location varchar(20),dates varchar(20),times varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertbooking(String name,String phone,String loc,String date,String time)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("bname",name);
        cv.put("servicename","mechanic");
        cv.put("contact",phone);
        cv.put("location",loc);
        cv.put("dates",date);
        cv.put("times",time);
        long res=db.insert(TABLE_NAME,null,cv);
        if(res==-1) return false;
        else return true;
    }
}
