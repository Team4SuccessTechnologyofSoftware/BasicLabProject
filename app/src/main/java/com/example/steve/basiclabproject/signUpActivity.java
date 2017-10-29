package com.example.steve.basiclabproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.widget.*;
import java.util.*;

public class signUpActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String REGISTER_URL = "https://team4success.000webhostapp.com/usersRegister.php";

    public static final String KEY_USERNAME = "Username";
    public static final String KEY_PASSWORD = "Password";
    public static final String KEY_EMAIL = "Email";
    public static final String KEY_LASTNAME= "lastName";
    public static final String KEY_FIRSTNAME= "firstName";
    public static final String KEY_PHONE= "PhoneNumber";
    public Toast toast=null;

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

    private void registerUser(){
        final String username = editTextUsername.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        final String email = editTextEmail.getText().toString().trim();
        final String lastName = editTextLastName.getText().toString().trim();
        final String firstName= editTextFirstName.getText().toString().trim();
        final String phone= editTextPhone.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        toast.makeText(signUpActivity.this,response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        toast.makeText(signUpActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_USERNAME, username);
                params.put(KEY_PASSWORD,password);
                params.put(KEY_EMAIL, email);
                params.put(KEY_FIRSTNAME, firstName);
                params.put(KEY_LASTNAME, lastName);
                params.put(KEY_PHONE, phone);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View v) {
        if(v == buttonRegister){
            registerUser();
        }
    }
}
