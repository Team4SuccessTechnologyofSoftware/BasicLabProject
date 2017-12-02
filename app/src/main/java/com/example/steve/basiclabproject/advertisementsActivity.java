package com.example.steve.basiclabproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ADIS HP on 2/12/2017.
 */

public class advertisementsActivity extends AppCompatActivity{
    private static final String GET_PRODUCTS = "https://team4success.000webhostapp.com/getProducts.php";
    private SharedPreferences sharedPreferences=null;
    private ListView mListView = null;
    private advertisementsAdapter adapter=null;
    Activity mActivity =null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advertisements);
        sharedPreferences = this.getSharedPreferences("sellApp", Context.MODE_PRIVATE);
        mListView = (ListView) findViewById(R.id.advertisements);
        mActivity = this;



        StringRequest stringRequest = new StringRequest(Request.Method.POST, GET_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(mActivity,"Here"+response.toString(), Toast.LENGTH_LONG).show();
                        if (!response.toString().isEmpty()) ;
                        {
//                        mListView.setAdapter(new advertisementsAdapter(getApplicationContext(),response.t));


                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(mActivity,"Here 1 "+ error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
//                Toast.makeText(getApplicationContext(),"Use "+ sharedPreferences.getString("UserID",null),Toast.LENGTH_LONG).show();
                params.put("UserID","11111203");
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(mActivity);
        requestQueue.add(stringRequest);





    }






    public void getProducts(){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, GET_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
                    if(!response.toString().isEmpty());
//                        mListView.setAdapter(new advertisementsAdapter(getApplicationContext(),response.t));


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                Toast.makeText(getApplicationContext(),"Use "+ sharedPreferences.getString("UserID",null),Toast.LENGTH_LONG).show();
                params.put("UserID",sharedPreferences.getString("UserID",null));
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(mActivity);
        requestQueue.add(stringRequest);
    }


}
