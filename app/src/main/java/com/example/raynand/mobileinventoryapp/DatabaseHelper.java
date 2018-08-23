package com.example.raynand.mobileinventoryapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

//    private static final int DATABASE_VERSION = 81718;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MobileAccount.db";
    private static final String TABLE_NAME = "MobileAccount";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_LASTNAME = "LastName";
    private static final String COLUMN_FIRSTNAME = "FirstName";
    private static final String COLUMN_USERNAME = "UserName";
    private static final String COLUMN_PASSWORD = "Password";
    private static final String COLUMN_EmailAddress = "EmailAddress";

    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table MobileAccount (id integer primary key not null, " +
            "LastName text not null, FirstName text not null, UserName text not null, Password text not null, EmailAddress text not null)";


    DatabaseHelper(Context context)
    {
        super(context , DATABASE_NAME , null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
            db.execSQL(TABLE_CREATE);
            this.db = db;
    }

    public  void insertUserinfo(UserInformation u)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select *from MobileAccount";
        Cursor cursor = db.rawQuery(query , null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_LASTNAME, u.getLastname());
        values.put(COLUMN_FIRSTNAME, u.getFirstName());
        values.put(COLUMN_USERNAME, u.getUsername());
        values.put(COLUMN_PASSWORD, u.getPassword());
        values.put(COLUMN_EmailAddress, u.getEmail());

        db.insert(TABLE_NAME , null , values);
        db.close();

    }

    public String searchPass(String username)
    {
        db = this.getReadableDatabase();
        String query = "select UserName,Password from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        String auser , bpass;
        bpass = "Not Found";

        if (cursor.moveToFirst())
        {
            do{
                auser = cursor.getString(0);


                if (auser.equals(username)) {
                bpass = cursor.getString(1);
                break;
                }
            }
            while (cursor.moveToNext());
        }
        return bpass;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
            String query = "DROP TABLE IF EXISTS " +TABLE_NAME;
            //String query = "DROP TABLE IF EXIST"+TABLE_NAME;
            db.execSQL(query);
            this.onCreate(db);
    }
}

//https://www.youtube.com/watch?v=NT1qxmqH1eM
//part 1 of the tutorial