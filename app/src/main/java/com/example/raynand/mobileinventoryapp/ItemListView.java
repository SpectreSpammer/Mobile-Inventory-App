package com.example.raynand.mobileinventoryapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ItemListView extends AppCompatActivity {

    DatabaseHelper1 myDB;
    ArrayList<Item> itemList;

    ListView listView;

    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list_view);

        listView = (ListView) findViewById(R.id.listView);

        myDB = new DatabaseHelper1(this);

        itemList = new ArrayList<>();
        Cursor data = myDB.getListContents();
        int numRows = data.getCount();

        if(numRows == 0){
            Toast.makeText(ItemListView.this, "There is nothing in the database.", Toast.LENGTH_LONG).show();
        }

        //TODO: add image column index to Item constructor data.getString() parameter
        else
        {
            while(data.moveToNext()){
                //TODO:
                item = new Item(data.getString(1), data.getString(2), data.getString(3));//

                itemList.add(item);
            }
            Row_ListAdapter adapter = new Row_ListAdapter(this, R.layout.list_adapter_view, itemList);

            listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(adapter);
        }
    }

    public void addItemClick(View v){
        Intent intent = new Intent(this, AddEdit.class);
        startActivity(intent);
    }
}
