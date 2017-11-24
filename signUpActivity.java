package com.example.steve.basiclabproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.steve.basiclabproject.ClassesCreation.signUp;

public class signUpActivity extends AppCompatActivity implements View.OnClickListener {

    private signUp mSignUp=null;
    private EditText editTextUsername;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextLastName;
    private EditText editTextFirstName;
    private EditText editTextPhone;

    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupscreen);
        editTextUsername = (EditText) findViewById(R.id.eTUserName);
        editTextPassword = (EditText) findViewById(R.id.eTPassword);
        editTextEmail= (EditText) findViewById(R.id.eTEmail);
        editTextLastName= (EditText) findViewById(R.id.eTLastName);
        editTextFirstName= (EditText) findViewById(R.id.eTFirstName);
        editTextPhone = (EditText) findViewById(R.id.eTPhoneNumber);
        buttonRegister = (Button) findViewById(R.id.btnSignUp);
        buttonRegister.setOnClickListener(this);
    }

    public void exit(View view){
        finish();
    }


    @Override
    public void onClick(View v) {
        if(v == buttonRegister){
            final String username = editTextUsername.getText().toString().trim();
            final String password = editTextPassword.getText().toString().trim();
            final String email = editTextEmail.getText().toString().trim();
            final String lastName = editTextLastName.getText().toString().trim();
            final String firstName= editTextFirstName.getText().toString().trim();
            final String phone= editTextPhone.getText().toString().trim();
            mSignUp = new signUp();
            mSignUp.signUpUser(this,username,password,email,lastName,firstName,phone);
        }
    }


}
