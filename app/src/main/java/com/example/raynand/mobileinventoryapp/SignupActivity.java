package com.example.raynand.mobileinventoryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignupActivity extends AppCompatActivity {

    private Button Signup;
    private Button Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Signup = (Button)findViewById(R.id.btnSignup);
        Back = (Button)findViewById(R.id.btnBack);

        Signup.setOnClickListener(new View.OnClickListener() {
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
        Intent intent = new Intent(this, SigninActivity.class);
        startActivity(intent);
    }

    public void OpenHome()
    {
        Intent intent = new Intent(this, StartPageActivity.class);
        startActivity(intent);
    }
}
