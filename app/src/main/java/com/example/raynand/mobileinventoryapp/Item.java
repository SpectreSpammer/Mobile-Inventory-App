package com.example.raynand.mobileinventoryapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;

public class Item implements Serializable{

    private String image, name, description;

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item(){

    }

    public Item(Bitmap image, String name, String description){
        this.image = bitmapToString(image);
        this.name = name;
        this.description = description;
    }

    public Item(String image, String name, String description){
        this.image=image;
        this.name=name;
        this.description=description;
    }

    public Bitmap getImage(){
        return stringToBitmap(this.image);
    }

    public String getImageString(){
        return image;
    }

    public String bitmapToString(Bitmap bitmap){
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray);
        byte[] b = byteArray.toByteArray();
        return Base64.encodeToString(b, Base64.DEFAULT);
    }

    public Bitmap stringToBitmap(String string){
        Bitmap bitmap = null;
        try{
            byte[] encodeByte = Base64.decode(string, Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return bitmap;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
}
