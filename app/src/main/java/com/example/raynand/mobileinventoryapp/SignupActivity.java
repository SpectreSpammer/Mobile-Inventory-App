package com.example.raynand.mobileinventoryapp;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.content.ContentValues.TAG;

public class SignupActivity extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);
    private Button Signup;
    private Button Back;
    private EditText lastname, firstname, username, password, confirmpass, emailaddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


    }

    public void onClickSignup(View v) {

        lastname = (EditText) findViewById(R.id.etLastName);
        firstname = (EditText) findViewById(R.id.etFirstName);
        username = (EditText) findViewById(R.id.etUsername);
        password = (EditText) findViewById(R.id.etPassword);
        confirmpass = (EditText) findViewById(R.id.etConfirmPass);
        emailaddress = (EditText) findViewById(R.id.etEmail);
        //assigning ID
        String lname = lastname.getText().toString();
        String fname = firstname.getText().toString();
        String user = username.getText().toString();
        String pass = password.getText().toString();
        String confirmPass = confirmpass.getText().toString();
        String emailadd = emailaddress.getText().toString();
        lastname.requestFocus();


        if (!pass.equals(confirmPass))
        {
            Toast pop = Toast.makeText(SignupActivity.this, "Password doesn`t match!", Toast.LENGTH_SHORT);
            pop.show();
        } else {

            // Log.d(TAG, "signUp");
            if (!validateForm())
            {
                return;
            }

            UserInformation userinfo = new UserInformation();
            userinfo.setLastName(lname);
            userinfo.setFirstName(fname);
            userinfo.setUsername(user);
            userinfo.setPassword(pass);
            userinfo.setEmail(emailadd);

            helper.insertUserinfo(userinfo);

            Toast pop = Toast.makeText(SignupActivity.this, "Success!", Toast.LENGTH_SHORT);
            pop.show();

            Intent intent = new Intent(this, SigninActivity.class);
            startActivity(intent);
        }
    }

    public boolean validateForm()
    {
        boolean result = true;

        if (TextUtils.isEmpty(lastname.getText().toString()))
        {
            lastname.setError("Required");
            result = false;
        }
            else
            {
            lastname.setError(null);
            }
        //lastname
        if (TextUtils.isEmpty(firstname.getText().toString()))
        {
            firstname.setError("Required");
            result = false;
        }
        else
            {
            firstname.setError(null);
            }
        //firstname
        if (TextUtils.isEmpty(username.getText().toString()))
        {
            username.setError("Required");
            result = false;
        }
            else
            {
            username.setError(null);
            }
        //username
        if (TextUtils.isEmpty(password.getText().toString()))
        {
            password.setError("Required");
            result = false;
        }
            else
            {
            password.setError(null);
            }
        //password
        if (TextUtils.isEmpty(confirmpass.getText().toString()))
        {
            confirmpass.setError("Required");
            result = false;
        }
        else
            {
            confirmpass.setError(null);
            }
        //confirmpass

        if (TextUtils.isEmpty(emailaddress.getText().toString()))
        {
            emailaddress.setError("Required");
            result = false;
        }
            else
            {
            emailaddress.setError(null);
            }

        //email add
        if(!ValidEmail(emailaddress.getText().toString()))
        {
            emailaddress.setError("Invalid Email Address");
            result = false;
         }
         else
        {
            emailaddress.setError(null);
        }

        return result;
    }

   public static boolean ValidEmail(String email) {

       if (email == null)
       {
           return false;
       }
       else
           {
           return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
            }
   }
   //https://stackoverflow.com/questions/22348212/android-check-if-an-email-address-is-valid-or-not

   //first valid

  /* public static boolean isEmailValid(String email)
    {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
*/



}
