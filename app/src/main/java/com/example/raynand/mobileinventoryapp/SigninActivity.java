package com.example.raynand.mobileinventoryapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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

    private SharedPreferences mPreferences;//
    private SharedPreferences.Editor mEditor;//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);//
        mEditor = mPreferences.edit();//
        checkSharedPreferences();//
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

                String username = uname.getText().toString();//
                mEditor.putString(getString(R.string.username), username);//
                mEditor.commit();//
            }

            else
            {
                Toast pop = Toast.makeText(SigninActivity.this, "Username and Password don`t match!", Toast.LENGTH_SHORT);
                pop.show();

            }
        }
    }
    private void checkSharedPreferences(){
        String name = mPreferences.getString(getString(R.string.username), "");
    }
}