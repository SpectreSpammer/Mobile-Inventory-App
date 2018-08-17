package com.example.raynand.mobileinventoryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {

    private Button Signup;
    private Button Back;
    private EditText username,password, confirmpass , emailaddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Signup = (Button)findViewById(R.id.btnSignup);
        Back = (Button)findViewById(R.id.btnBack);
        username = (EditText)findViewById(R.id.etUsername);
        password = (EditText)findViewById(R.id.etPassword);
        confirmpass = (EditText)findViewById(R.id.etConfirmPass);
        emailaddress = (EditText)findViewById(R.id.etEmail);



        //setting their ID

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
