package com.example.raynand.mobileinventoryapp;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AddEdit extends AppCompatActivity {

    private static final int PERMISSION_REQUEST = 0;
    private static final int RESULT_LOAD_IMAGE = 1;

    Bitmap bm;
    String imgToStr;
    TextView tvUname;
    ImageView imageView;
    EditText etName, etDesc;
    Button btnAdd, btnCancel, addImage;
    DatabaseHelper myDB;
    Item imageToStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        ItemListView edit = new ItemListView();

        etName = (EditText) findViewById(R.id.aeName);
        etDesc = (EditText) findViewById(R.id.aeDescription);
        btnAdd = (Button) findViewById(R.id.addBtn);
        btnCancel = (Button) findViewById(R.id.cancelBtn);
        imageView = (ImageView) findViewById(R.id.imageView);
        addImage = (Button) findViewById(R.id.aeAddImg);
        btnCancel = (Button) findViewById(R.id.cancelBtn2);
        myDB = new DatabaseHelper(this);
        imageToStr = new Item();

        tvUname = (TextView) findViewById(R.id.aetvUsername);//---------------------------------------------------
        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);//---------------------------------------------------
        SharedPreferences.Editor editor = mPreferences.edit();//---------------------------------------------------
        String username = mPreferences.getString(getString(R.string.username),"");//---------------------------------------------------
        tvUname.setText(username);//---------------------------------------------------

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bm = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
                imgToStr = imageToStr.bitmapToString(bm);
                String name = etName.getText().toString();
                String description = etDesc.getText().toString();

                if(name.length()!= 0 && description.length()!= 0){
                    Intent intent = new Intent(AddEdit.this, ItemListView.class);

                    AddData(imgToStr, name, description);

                    startActivity(intent);

                } else {
                    Toast.makeText(AddEdit.this, "Can't leave text field blank!", Toast.LENGTH_LONG).show();
                }
            }
        });

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST);
        }

        addImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddEdit.this, ItemListView.class);
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
                    imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                }
        }
    }

    public void AddData(String image, String name, String desc){

        boolean insertData = myDB.addData(image, name, desc);
        if(insertData) {
            Toast.makeText(AddEdit.this, "Data inserted successfully!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(AddEdit.this, "Something went wrong!", Toast.LENGTH_LONG).show();
        }
    }
}