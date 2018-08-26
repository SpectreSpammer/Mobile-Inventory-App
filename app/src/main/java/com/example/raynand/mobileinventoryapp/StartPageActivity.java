package com.example.raynand.mobileinventoryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartPageActivity extends AppCompatActivity {

    private Button Signin;
    private Button Signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage);

        getSupportActionBar().setTitle("BOBONG APP by Gadon " );
        Signin = (Button)findViewById(R.id.btnSignin);
        Signup = (Button)findViewById(R.id.btnSignup);

        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenSignin();

            }
        });
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
              public void onClick(View v) {
                OpenSignup();

            }
        });
        }

    public void OpenSignin()
    {
        Intent intent = new Intent(this, SigninActivity.class);
        startActivity(intent);
    }

    public void OpenSignup()
    {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }
}
