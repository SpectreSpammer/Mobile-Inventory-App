package com.example.raynand.mobileinventoryapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends Activity {


    DatabaseHelper helper = new DatabaseHelper(this);
    private Button Signup;
    private Button Back;
    private EditText lastname, firstname, username, password, confirmpass, emailaddress;

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);




    }

    public void onClickSignup(View v) {
        if (v.getId() == R.id.etLastName) {

            //Signup = (Button) findViewById(R.id.btnSignup);
            //Back = (Button) findViewById(R.id.btnBack);
            lastname = (EditText) findViewById(R.id.etLastName);
            firstname = (EditText) findViewById(R.id.etFirstName);
            username = (EditText) findViewById(R.id.etUsername);
            password = (EditText) findViewById(R.id.etPassword);
            confirmpass = (EditText) findViewById(R.id.etConfirmPass);
            emailaddress = (EditText) findViewById(R.id.etEmail);

            String lname = lastname.getText().toString();
            String fname = firstname.getText().toString();
            String user = username.getText().toString();
            String pass = password.getText().toString();
            String confirmPass = confirmpass.getText().toString();
            String emailadd = emailaddress.getText().toString();

            if (!pass.equals(confirmPass))
            {
                Toast pop = Toast.makeText(SignupActivity.this, "Password doesn`t match!", Toast.LENGTH_SHORT);
                pop.show();

            }

            else
            {
                UserInformation userinfo  = new UserInformation();
                userinfo.setLastName(lname);
                userinfo.setFirstName(fname);
                userinfo.setUsername(user);
                userinfo.setPassword(pass);
                userinfo.setEmail(lname);

                helper.insertUserinfo(userinfo);

            }
        }

    }


}
