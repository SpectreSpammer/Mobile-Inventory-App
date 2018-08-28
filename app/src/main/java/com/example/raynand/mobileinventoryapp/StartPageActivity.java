package com.example.raynand.mobileinventoryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartPageActivity extends AppCompatActivity {

<<<<<<< HEAD
    private Button Signin;
    private Button Signup;

=======

    private Button Signin;
    private Button Signup;
>>>>>>> kevinbackup
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage);

<<<<<<< HEAD
        getSupportActionBar().setTitle("BOBONG APP by Gadon" );
=======
        getSupportActionBar().setTitle("BOBONG APP by Gadon " );
>>>>>>> kevinbackup
        Signin = (Button)findViewById(R.id.btnSignin);
        Signup = (Button)findViewById(R.id.btnSignup);

        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenSignin();

            }
        });
<<<<<<< HEAD
=======


>>>>>>> kevinbackup
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
              public void onClick(View v) {
                OpenSignup();

            }
        });
<<<<<<< HEAD
        }

=======


        }
>>>>>>> kevinbackup
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
