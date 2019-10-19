package com.example.mrapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.sql.SQLData;
import java.util.ArrayList;

public class SQLHelper extends SQLiteOpenHelper {

    public static final String DBname= "data.db";

    public SQLHelper(Context context) {
        super(context, DBname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table words (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,mean TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS words");
        onCreate(db);

    }

    public boolean inserData(String name , String mean ){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues Content = new ContentValues();
        Content.put("name",name);
        Content.put("mean",mean);
        long result = DB.insert("words",null,Content);

        if(result ==-1)

        return false;
        else
            return true;

    }




    public ArrayList getAllInput(){
        ArrayList arrayList= new ArrayList();
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from words",null);
        res.moveToFirst();
        while (res.isAfterLast()==false){
            // arrayList.add(res.getString(res.getColumnIndex("name")));
            String t1= res.getString(0);//              das bringt die ID
            String t2 = res.getString(1);
            String t3 = res.getString(2);
            arrayList.add(""+t1+"- "+t2+":                     "+t3);
            res.moveToNext();

        }return arrayList;}




        public ArrayList getAllMeans(){
            ArrayList arrayList= new ArrayList();
            SQLiteDatabase db= this.getReadableDatabase();
            Cursor res = db.rawQuery("select * from words",null);
            res.moveToFirst();
            while (res.isAfterLast()==false){
                // arrayList.add(res.getString(res.getColumnIndex("name")));
               // String t1= res.getString(0);//              das bringt die ID
               // String t2 = res.getString(1);
                String t3 = res.getString(2);
                arrayList.add(""+t3);
                res.moveToNext();

            }return arrayList;}

        public ArrayList getAllNamewithID(){
            ArrayList arrayList= new ArrayList();
            SQLiteDatabase db= this.getReadableDatabase();
            Cursor res = db.rawQuery("select * from words",null);
            res.moveToFirst();
            while (res.isAfterLast()==false){
                // arrayList.add(res.getString(res.getColumnIndex("name")));
                String t1= res.getString(0);//              das bringt die ID
                String t2 = res.getString(1);
                //String t3 = res.getString(2);
                arrayList.add(""+t1+"- "+t2);
                res.moveToNext();

            }return arrayList;}







        public ArrayList getAllID(){
            ArrayList arrayList= new ArrayList();
            SQLiteDatabase db= this.getReadableDatabase();
            Cursor res = db.rawQuery("select * from words",null);
            res.moveToFirst();
            while (res.isAfterLast()==false){
                // arrayList.add(res.getString(res.getColumnIndex("name")));
                String t1= res.getString(0);//              das bringt die ID
               // String t2 = res.getString(1);
                //String t3 = res.getString(2);
                arrayList.add(""+t1);
                res.moveToNext();

            }return arrayList;}

    }
