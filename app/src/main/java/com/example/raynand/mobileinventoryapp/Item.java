package com.example.raynand.mobileinventoryapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public class Item {

    //TODO: create image variable
    private String image;//

    private String name;
    private String description;

    public Item(){

    }

    //TODO: add image parameter to constructor
    public Item(Bitmap image, String name, String description){
        this.image = bitmapToString(image);
        this.name = name;
        this.description = description;
    }//

    //TODO:
    public Item(String image, String name, String description){
        this.image=image;
        this.name=name;
        this.description=description;
    }
//    public Item(String name, String description){
//        this.name = name;
//        this.description = description;
//    }

    //TODO:declare get method for image
    public Bitmap getImage(){
        return stringToBitmap(this.image);
    }//

    //TODO:
//    public String getImageAsString(){
//        return this.image;
//    }

    //TODO:
    public String bitmapToString(Bitmap bitmap){
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray);
        byte[] b = byteArray.toByteArray();
        return Base64.encodeToString(b, Base64.DEFAULT);
    }//

    //TODO:
    public Bitmap stringToBitmap(String string){
        Bitmap bitmap = null;
        try{
            byte[] encodeByte = Base64.decode(string, Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return bitmap;
    }//

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
}
