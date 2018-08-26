//package com.example.raynand.mobileinventoryapp;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.graphics.Bitmap;
//
//public class DatabaseHelper1 extends SQLiteOpenHelper{
//
//    //TODO: create a column for image in database table
//    public static final String DATABASE_NAME = "items.db";
//    public static final String TABLE_NAME = "items_data";
////    public static final String COL1 = "ID";
////    public static final String COL2 = "NAME";
////    public static final String COL3 = "DESCRIPTION";
//
//    public static final String COL0 = "ID";
//    public static final String COL1 = "IMAGE";
//    public static final String COL2 = "NAME";
//    public static final String COL3 = "DESCRIPTION";
//
//    public DatabaseHelper1(Context context){
//        super(context, DATABASE_NAME, null, 1);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db){
//        //TODO:
//        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, IMAGE TEXT, NAME TEXT, DESCRIPTION TEXT)";//
////        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
////                " NAME TEXT, DESCRIPTION TEXT)";
//        db.execSQL(createTable);
//    }
//
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        onCreate(db);
//    }
//
//    //TODO: add image parameter to addData method
//    //TODO: add image column and argument to contentValues.put()
//    public boolean addData(String image, String name, String description){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL1, image);
//        contentValues.put(COL2, name);
//        contentValues.put(COL3, description);
//        long result = db.insert(TABLE_NAME, null, contentValues);
//        if(result == -1){
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//    public Cursor getListContents(){
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
//        return data;
//    }
//}
