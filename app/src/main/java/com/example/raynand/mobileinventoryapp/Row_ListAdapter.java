package com.example.raynand.mobileinventoryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Row_ListAdapter extends ArrayAdapter<Item> {

    private LayoutInflater mInflater;
    private ArrayList<Item> items;
    private int mViewResourceId;

    public Row_ListAdapter(Context context, int textViewResourceId, ArrayList<Item> items){
        super(context, textViewResourceId, items);
        this.items = items;

        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parents){

        convertView = mInflater.inflate(mViewResourceId, null);

        Item item = items.get(position);

        if(item != null){

            ImageView image = (ImageView) convertView.findViewById(R.id.iconIV);
            TextView name = (TextView) convertView.findViewById(R.id.nameTV);
            TextView description = (TextView) convertView.findViewById(R.id.descTV);

            if(image != null){
                image.setImageBitmap(item.getImage());
            }
            if(name != null){
                name.setText(item.getName());
            }
            if(description != null){
                description.setText(item.getDescription());
            }
        }
        return convertView;
    }
}
