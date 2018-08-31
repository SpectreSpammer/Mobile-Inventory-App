package com.example.raynand.mobileinventoryapp;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ViewItemClicked extends AppCompatActivity {

    ImageView image;
    TextView name, desc;
    Item item, passImage;
    Button editBtn, delBtn;
    String passName, passDesc, bmToStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        item = (Item) getIntent().getSerializableExtra("dataItem");

        setContentView(R.layout.activity_view_item_clicked);

        image = (ImageView) findViewById(R.id.viewImage);
        name = (TextView) findViewById(R.id.viewName);
        desc = (TextView) findViewById(R.id.viewDesc);

        image.setImageBitmap(item.getImage());
        name.setText(item.getName());
        desc.setText(item.getDescription());


        editBtn = (Button) findViewById(R.id.btnEdit);
        delBtn = (Button) findViewById(R.id.btnDelete);

        editBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(ViewItemClicked.this, EditItem.class);
                Bundle b = new Bundle();
                Bitmap bmp = ((BitmapDrawable)image.getDrawable()).getBitmap();

                Item passImage = new Item(bmp);
                passName = name.getText().toString();
                passDesc = desc.getText().toString();

                b.putSerializable("PASSIMAGE", passImage);
                b.putString("NAME", passName);
                b.putString("DESCRIPTION", passDesc);

                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}