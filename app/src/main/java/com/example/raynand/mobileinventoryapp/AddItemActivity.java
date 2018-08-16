package com.example.raynand.mobileinventoryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddItemActivity extends AppCompatActivity {

    String itemName;
    String itemDesc;
    //picture variable;
    TextView tvItemName = (TextView) findViewById(R.id.addItemName);
    TextView tvItemDesc = (TextView) findViewById(R.id.addItemDesc);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

    }

    public void setItemDetails(String itemName, String itemDesc){
        this.itemName = itemName;
        this.itemDesc = itemDesc;
    }

    public String getItemName(){
        return itemName;
    }

    public String getItemDesc(){
        return itemDesc;
    }

    public void addItemDetailsClick(View v){
        String strItemName = tvItemName.getText().toString();
        String strItemDesc = tvItemDesc.getText().toString();

        setItemDetails(strItemName, strItemDesc);
    }
}
