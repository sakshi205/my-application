package com.e.childnutrition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    //Variables
    TextInputLayout regFullName,regContactNumber,regEmail,regUsername,regPassword,regConfirmPassword;
    Button regLogIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //hooks to all xml elements in activity_register.xml
        regFullName = findViewById(R.id.txt_full_name);
        regContactNumber = findViewById(R.id.txt_contact_number);
        regEmail = findViewById(R.id.txt_email);
        regUsername = findViewById(R.id.txt_username);
        regPassword = findViewById(R.id.txt_password);
        regConfirmPassword = findViewById(R.id.txt_confirm_password);
        regLogIn = findViewById(R.id.btn_login);

        regLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    //Full Name Validation
    private Boolean validateName(){
        String full_name = regFullName.getEditText().getText().toString();

        if(full_name.isEmpty()){
            regFullName.setError("Field cannot be empty");
            return false;
        }
        else {
            regFullName.setError(null);//adding null so that when user fills up the name, the error is to be gone
            regFullName.setErrorEnabled(false);//to remove the space when the user fills the field
            return true;
        }
    }

    //Contact Number Validation
    private Boolean validateContactNumber(){
        String contact_number = regContactNumber.getEditText().getText().toString();

        if(contact_number.isEmpty()){
            regContactNumber.setError("Field cannot be empty");
            return false;
        }
        else {
            regContactNumber.setError(null);//adding null so that when user fills up the name, the error is to be gone
            regContactNumber.setErrorEnabled(false);//to remove the space when the user fills the field
            return true;
        }
    }

    //Email Validation
    private Boolean validateEmail(){
        String email = regEmail.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (email.isEmpty()) {
            regEmail.setError("Field cannot be empty");
            return false;
        } else if (!email.matches(emailPattern)) {
            regEmail.setError("Invalid email address");
            return false;
        } else {
            regEmail.setError(null);
            regEmail.setErrorEnabled(false);
            return true;
        }
    }

    //Username Validation
    private Boolean validateUsername(){
        String username = regUsername.getEditText().getText().toString();
        String noWhiteSpace = "\\\\A\\\\w{4,20}\\\\z";
        if(username.isEmpty()){
            regUsername.setError("Field cannot be empty");
            return false;
        }
        else if(username.length()>12) {
            regUsername.setError("Username too long.Only 12 characters allowed");
            return false;

        }
        else if(!username.matches(noWhiteSpace)){
            regUsername.setError("Whitespace not allowed");
            return false;
        }

        else {
            regUsername.setError(null);//adding null so that when user fills up the name, the error is to be gone
            regUsername.setErrorEnabled(false);
            return true;
        }
    }

    //Password Validation
    private Boolean validatePassword(){
        String password = regPassword.getEditText().getText().toString();
        String passwordValue = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

        if (password.isEmpty()) {
            regPassword.setError("Field cannot be empty");
            return false;
        } else if (!password.matches(passwordValue)) {
            regPassword.setError("Password too weak");
            return false;
        } else {
            regPassword.setError(null);
            regPassword.setErrorEnabled(false);
            return true;
        }
    }

    //Confirm Password Validation
    private Boolean validateConfirmPassword(){
        String password = regPassword.getEditText().getText().toString();
        String confirm_password = regConfirmPassword.getEditText().getText().toString();

        if(confirm_password.isEmpty()){
            regConfirmPassword.setError("Field cannot be empty");
            return false;
        }
        else if (!password.matches(confirm_password)){
            regConfirmPassword.setError("Passwords do not match");
            return false;
        }
        else {
            regConfirmPassword.setError(null);//adding null so that when user fills up the name, the error is to be gone
            return true;
        }
    }



    public void registerUser(View view){
        if(!validateName() | !validateContactNumber() | !validateEmail() | !validateUsername() | !validatePassword() | !validateConfirmPassword()){
            return;
        }

        //Getting all the values in string
//        String full_name = regFullName.getEditText().getText().toString();
//        String contact_number = regContactNumber.getEditText().getText().toString();
//        String email = regEmail.getEditText().getText().toString();
//        String username = regUsername.getEditText().getText().toString();
//        String password = regPassword.getEditText().getText().toString();
//        String confirm_password = regConfirmPassword.getEditText().getText().toString();
    }


}
