package com.example.raynand.mobileinventoryapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class ItemListView extends AppCompatActivity {

    DatabaseHelper myDB;

    ArrayList<Item> itemList;
    ListView listView;
    TextView tvUname;
    String username;

    Item item;
    int userLoggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list_view);

//        tvUname = (TextView) findViewById(R.id.ilvTextView);//---------------------------------------------------
//        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);//---------------------------------------------------
//        SharedPreferences.Editor editor = mPreferences.edit();//---------------------------------------------------
//        String name = mPreferences.getString(getString(R.string.name),"");//---------------------------------------------------
//        tvUname.setText(name);//---------------------------------------------------

        listView = (ListView) findViewById(R.id.listView);
        myDB = new DatabaseHelper(this);
        itemList = new ArrayList<>();
        Cursor data = myDB.getListContents();

        //TODO: connect users with their items if(userExists==true){}

        int numRows = data.getCount();
        if(numRows == 0){
            Toast.makeText(ItemListView.this, "There is nothing in the database.", Toast.LENGTH_SHORT).show();
        } else {
            while(data.moveToNext()){
                item = new Item(data.getString(1), data.getString(2), data.getString(3));
                itemList.add(item);
            }
            Row_ListAdapter adapter = new Row_ListAdapter(this, R.layout.list_adapter_view, itemList);
            listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(adapter);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //MOF's code
                Item passItem = itemList.get(position);
                Intent intent = new Intent(ItemListView.this, ViewItemClicked.class);
                Bundle itemBundle = new Bundle();
                itemBundle.putSerializable("dataItem", passItem);
                intent.putExtras(itemBundle);
                startActivity(intent);//
            }
        });
    }

    public void addItemClick(View v){
        Intent intent = new Intent(this, AddEdit.class);
        startActivity(intent);
    }

    public void logOutClick(View v){
        Intent intent = new Intent(ItemListView.this, SigninActivity.class);
        startActivity(intent);
    }
}