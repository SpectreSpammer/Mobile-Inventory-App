package com.example.raynand.mobileinventoryapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class EditItem extends AppCompatActivity {

    private static final int PERMISSION_REQUEST = 0;
    private static final int RESULT_LOAD_IMAGE = 1;

    ImageView ivImage;
    EditText etName, etDesc;
    String rcvName, rcvDesc, imgToStr;
    Button editImage, saveItem, cancelBtn;
    Item item, imageToStr;
    DatabaseHelper db;
    Bitmap bm;

    //int itemID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        ivImage = (ImageView) findViewById(R.id.eiImageView);
        etName = (EditText) findViewById(R.id.eiName);
        etDesc = (EditText) findViewById(R.id.eiDescription);
        editImage = (Button) findViewById(R.id.eiAddImg);
        saveItem = (Button) findViewById(R.id.saveBtn);
        cancelBtn = (Button) findViewById(R.id.cancelBtn);

        rcvName = getIntent().getExtras().getString("NAME");
        rcvDesc = getIntent().getExtras().getString("DESCRIPTION");
        item = (Item) getIntent().getSerializableExtra("PASSIMAGE");

        ivImage.setImageBitmap(item.getImage());
        etName.setText(rcvName);
        etDesc.setText(rcvDesc);

        db = new DatabaseHelper(this);
        imageToStr = new Item();

        editImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, RESULT_LOAD_IMAGE);
            }
        });

        saveItem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(EditItem.this, ItemListView.class);
                db.deleteRow(rcvDesc);

                bm = ((BitmapDrawable)ivImage.getDrawable()).getBitmap();
                imgToStr = imageToStr.bitmapToString(bm);
                String name = etName.getText().toString();
                String description = etDesc.getText().toString();

                if(name.length()!= 0 && description.length()!= 0){
                    Intent intent1 = new Intent(EditItem.this, ItemListView.class);

                    AddData(imgToStr, name, description);

                    etName.setText("");
                    etDesc.setText("");

                    startActivity(intent1);

                } else {
                    Toast.makeText(EditItem.this, "Can't leave text field blank!", Toast.LENGTH_LONG).show();
                }
                startActivity(intent);
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(EditItem.this, ItemListView.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PERMISSION_REQUEST:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Permission granted!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this,"Permission not granted!", Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        switch (requestCode){
            case RESULT_LOAD_IMAGE:
                if(resultCode==RESULT_OK){
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    cursor.close();
                    ivImage.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                }
        }
    }

    public void AddData(String image, String name, String desc){
        boolean insertData = db.addData(image, name, desc);
        if(insertData) {
            Toast.makeText(EditItem.this, "Data inserted successfully!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(EditItem.this, "Something went wrong!", Toast.LENGTH_LONG).show();
        }
    }

}
