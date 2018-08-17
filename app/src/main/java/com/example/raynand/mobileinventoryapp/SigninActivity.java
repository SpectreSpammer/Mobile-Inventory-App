package com.example.raynand.mobileinventoryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SigninActivity extends AppCompatActivity {


    private Button Signin;
    private Button Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        Signin = (Button)findViewById(R.id.btnSigin);
        Back = (Button)findViewById(R.id.btnBack);

        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenSignin();
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenHome();
            }
        });
    }

    public void OpenSignin()
    {
        Intent intent = new Intent(this, InventoryActivity.class);
        startActivity(intent);
    }

    public void OpenHome()
    {
        Intent intent = new Intent(this, StartPageActivity.class);
        startActivity(intent);
    }
}
