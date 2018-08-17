package com.example.raynand.mobileinventoryapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {



    private static final int DATABASE_VERSION = 81718;
    private static final String DATABASE_NAME = "MobileAccount.db";
    private static final String TABLE_NAME = "MobileAccount";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_LASTNAME = "LastName";
    private static final String COLUMN_FIRSTNAME = "FirstName";
    private static final String COLUMN_USERNAME = "UserName";
    private static final String COLUMN_PASSWORD = "Password";
    private static final String COLUMN_EmailAddress = "EmailAddress";
    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table MobileAccount (id integer primary key autoincrement , " +
            "LastName text not null , FirstName text not null , UserName text not null , Password text not null );";


    DatabaseHelper(Context context)
    {
        super(context , DATABASE_NAME , null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(TABLE_CREATE);
            this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String query = "DROP TABLE IF EXIST"+TABLE_NAME;
            db.execSQL(query);
            this.onCreate(db);
    }
}

//https://www.youtube.com/watch?v=NT1qxmqH1eM
//part 1 of the tutorial