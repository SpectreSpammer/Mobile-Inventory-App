package com.example.raynand.mobileinventoryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {


    DatabaseHelper helper = new DatabaseHelper(this);
    private Button Signin;
    private Button Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
    }

    public void onClickSignin (View v)
    {
        if (v.getId() == R.id.btnSignin);
        {
            EditText uname = (EditText)findViewById(R.id.etUsername);
            String us = uname.getText().toString();
            EditText pass = (EditText)findViewById(R.id.etPassword);
            String p = pass.getText().toString();

            String password =  helper.searchPass(us);
            if (p .equals((password)))
            {
                Intent intent = new Intent(this, ItemListView.class);
                intent.putExtra("Username", us);
                startActivity(intent);
            }

            else
            {
                Toast pop = Toast.makeText(SigninActivity.this, "Username and Password don`t match!", Toast.LENGTH_SHORT);
                pop.show();

            }
        }
    }
}
