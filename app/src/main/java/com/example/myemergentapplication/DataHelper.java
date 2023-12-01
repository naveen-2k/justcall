package com.example.myemergentapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME="Emer.db";
    public static final String TABLE_NAME="userdetails";
    public static final String COL_1="NAME";
    public static final String COL_2="AGE";
    public static final String COL_3="CONTACT";
    public static final String COL_4="LOCATION";


    public DataHelper(@Nullable Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("create table "+TABLE_NAME+" (NAME VARCHAR(20),AGE INT ,CONTACT VARCHAR(20),LOCATION VARCHAR(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public boolean insertdata(String name,int age,String contact,String location)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,age);
        contentValues.put(COL_3,contact);
        contentValues.put(COL_4,location);
        long result=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
           return false;
        else
            return  true;
    }

    public String retrive()
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor res=sqLiteDatabase.rawQuery("select "+COL_1+" from "+TABLE_NAME,null);
        res.moveToFirst();
        String name= res.getString(0);
        res.close();
        return  name;
    }
    public String getserviceprovider()
    {
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor res=database.rawQuery("select * from server where servername = 'vikram' ",null);
        res.moveToFirst();
        String name=res.getString(0);
        res.close();
        return name;
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
        long res=db.insert("bookings",null,cv);
        if(res==-1) return false;
        else return true;
    }

}

