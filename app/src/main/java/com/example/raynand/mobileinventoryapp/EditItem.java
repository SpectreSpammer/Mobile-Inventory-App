package com.example.raynand.mobileinventoryapp;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class EditItem extends AppCompatActivity {

    ImageView ivImage;
    EditText etName, etDesc;
    String rcvName, rcvDesc;
    Bitmap bm, rcvImg;
    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        ivImage = (ImageView) findViewById(R.id.eiImageView);
        etName = (EditText) findViewById(R.id.eiName);
        etDesc = (EditText) findViewById(R.id.eiDescription);

        rcvName = getIntent().getExtras().getString("NAME");
        rcvDesc = getIntent().getExtras().getString("DESCRIPTION");
        item = (Item) getIntent().getSerializableExtra("PASSIMAGE");

        ivImage.setImageBitmap(item.getImage());
        etName.setText(rcvName);
        etDesc.setText(rcvDesc);
    }
}
