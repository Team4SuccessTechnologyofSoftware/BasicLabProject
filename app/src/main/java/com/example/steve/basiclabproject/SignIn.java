package com.example.steve.basiclabproject;

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

import java.util.HashMap;
import java.util.Map;

public class SignIn extends AppCompatActivity  implements View.OnClickListener {
    //--dokimi gia branch--

    private static final String REGISTER_URL = "https://team4success.000webhostapp.com/login_in.php";


    public static final String KEY_USERNAME = "Username";
    public static final String KEY_PASSWORD = "Password";


    private EditText editTextUsername;
    private EditText editTextPassword;

    private Button btn;
    private Button btn2;
    //safd

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_screen);
        editTextUsername = (EditText) findViewById(R.id.TUserName);
        editTextPassword = (EditText) findViewById(R.id.TPassword);
        btn= (Button)findViewById(R.id.signinButton);
        btn.setOnClickListener(this);
    }

    public void exit(View view){

        btn2= (Button)findViewById(R.id.buttonBack);
        finish();
    }

    private void signInUser(){
        final String username = editTextUsername.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(SignIn.this,response.toString(),Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SignIn.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_USERNAME, username);
                params.put(KEY_PASSWORD,password);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View v) {
        if(v == btn){
            signInUser();
        }
    }

    }

