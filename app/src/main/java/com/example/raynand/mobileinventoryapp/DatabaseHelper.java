package com.example.raynand.mobileinventoryapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    //private static final int DATABASE_VERSION = 81718;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MobileAccount.db";
    private static final String TABLE_ACCNAME = "Account";
    private static final String COLUMN_ACCID = "id";
    private static final String COLUMN_ACCLASTNAME = "LastName";
    private static final String COLUMN_ACCFIRSTNAME = "FirstName";
    private static final String COLUMN_ACCUSERNAME = "UserName";
    private static final String COLUMN_ACCPASSWORD = "Password";
    private static final String COLUMN_ACCEmailAddress = "EmailAddress";

    // Account Database and  Table Name


    public static final String TABLE_ITEMNAME = "Items";
    public static final String ITEMID = "ID";
    public static final String ITEMIMAGE = "IMAGE";
    public static final String ITEMNAME = "NAME";
    public static final String ITEMDESCRI = "DESCRIPTION";

    // Items Table

    SQLiteDatabase db;

    private static final String TABLE_ACCCREATE = "create table MobileAccount (id integer primary key not null, " +
            "LastName text not null, FirstName text not null, UserName text not null, Password text not null, EmailAddress text not null)";

    private static final String TABLE_ITEMCREATE = "create table items (ID integer primary key not null, " +
            "IMAGE text not null, NAME text not null, DESCRIPTION text not null)";

    DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        db.execSQL(TABLE_ACCCREATE);
        db.execSQL(TABLE_ITEMCREATE);
        //this.db = db;

    }

    public  void insertUserinfo(UserInformation u) {

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select *from Account";
        Cursor cursor = db.rawQuery(query , null);
        int count = cursor.getCount();

        values.put(COLUMN_ACCID, count);
        values.put(COLUMN_ACCLASTNAME, u.getLastname());
        values.put(COLUMN_ACCFIRSTNAME, u.getFirstName());
        values.put(COLUMN_ACCUSERNAME, u.getUsername());
        values.put(COLUMN_ACCPASSWORD, u.getPassword());
        values.put(COLUMN_ACCEmailAddress, u.getEmail());

        db.insert(TABLE_ACCNAME , null , values);
        db.close();
    }
    //inserting of User info in user information class

    public String searchPass(String username) {
        db = this.getReadableDatabase();
        String query = "select UserName,Password from " + TABLE_ACCNAME;
        Cursor cursor = db.rawQuery(query, null);

        String auser, bpass;
        bpass = "Not Found";

        if (cursor.moveToFirst()) {
            do{
                auser = cursor.getString(0);

                if (auser.equals(username)) {
                    bpass = cursor.getString(1);
                    break;
                }
            } while (cursor.moveToNext());
        }
        return bpass;
    }
    //about Sign in activity


    public boolean addData(String image, String name, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ITEMIMAGE, image);
        contentValues.put(ITEMNAME, name);
        contentValues.put(ITEMDESCRI, description);

        long result = db.insert(TABLE_ITEMNAME, null, contentValues);

        if(result == -1){
            return false;
        } else {
            return true;
        }
    }

    //items inserting of data

    public Cursor getListContents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_ITEMNAME, null);
        return data;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " +TABLE_ACCNAME;
        String query1 = "DROP TABLE IF EXISTS " +TABLE_ITEMNAME;
        //String query = "DROP TABLE IF EXIST"+TABLE_NAME;

        db.execSQL(query);
        db.execSQL(query1);
        this.onCreate(db);

    }

//    public String queryEditString(){
//        String query = "SELECT IMAGE, NAME, DESCRIPTION FROM " + TABLE_ITEMNAME;
//        db.execSQL(query);
//        return query;
//    }
//    public Cursor queryEditCursor(){
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor data = db.rawQuery("SELECT IMAGE, NAME, DESCRIPTION FROM " + TABLE_ITEMNAME, null);
//        return data;
//    }
}

//https://www.youtube.com/watch?v=NT1qxmqH1eM
//part 1 of the tutorial


















