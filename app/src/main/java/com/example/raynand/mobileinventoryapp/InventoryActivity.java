package com.example.raynand.mobileinventoryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class InventoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        ListView inventoryList = findViewById(R.id.itemList);

    }

    public void addButtonClick(View v){
        Intent addItemIntent = new Intent(InventoryActivity.this, AddItemActivity.class);
        startActivity(addItemIntent);
    }
}
