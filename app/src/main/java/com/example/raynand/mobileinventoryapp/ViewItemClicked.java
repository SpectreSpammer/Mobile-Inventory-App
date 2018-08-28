package com.example.raynand.mobileinventoryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewItemClicked extends AppCompatActivity {

    ImageView image;
    TextView name, desc;
    Item item;
    Button editBtn, delBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        item = (Item) getIntent().getSerializableExtra("dataItem");

        setContentView(R.layout.activity_view_item_clicked);

        name = (TextView) findViewById(R.id.viewName);
        desc = (TextView) findViewById(R.id.viewDesc);
        image = (ImageView) findViewById(R.id.viewImage);

        editBtn = (Button) findViewById(R.id.btnEdit);
        delBtn = (Button) findViewById(R.id.btnDelete);

        name.setText(item.getName());
        desc.setText(item.getDescription());
        image.setImageBitmap(item.getImage());
    }
}