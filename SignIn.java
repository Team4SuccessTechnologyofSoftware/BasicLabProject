package com.example.steve.basiclabproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.steve.basiclabproject.ClassesCreation.login;

import java.util.HashMap;
import java.util.Map;

public class SignIn extends AppCompatActivity implements View.OnClickListener {

    public static final String KEY_USERNAME = "Username";
    public static final String KEY_PASSWORD = "Password";
    private static final String REGISTER_URL = "https://team4success.000webhostapp.com/login_in.php";
    private EditText editTextUsername;
    private EditText editTextPassword;

    private Button btn;
    private Button btn2;

    private login Login =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_screen);
        Login=new login();
        editTextUsername = (EditText) findViewById(R.id.TUserName);
        editTextPassword = (EditText) findViewById(R.id.TPassword);
        btn = (Button) findViewById(R.id.signinButton);
        btn.setOnClickListener(this);
    }


    public void exit(View view) {

        btn2 = (Button) findViewById(R.id.buttonBack);
        finish();
    }




    @Override
    public void onClick(View v) {

        if (v == btn) {
            final String username = editTextUsername.getText().toString().trim();
            final String password = editTextPassword.getText().toString().trim();

            Login.userLogin(username,password,this);
        }
    }

}

