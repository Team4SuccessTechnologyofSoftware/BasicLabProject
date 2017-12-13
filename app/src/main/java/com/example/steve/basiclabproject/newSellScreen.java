package com.example.steve.basiclabproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

/**
 * Created by ADIS HP on 5/12/2017.
 */

public class newSellScreen extends AppCompatActivity {
    private static final String UPDATE_PRODUCTS = "https://team4success.000webhostapp.com/updateProducts.php";
    private String productName,ProductDescription,ProductPrice,Lat,Long,image;
    private EditText name,desc,price,location;
    private String id;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_sell_screen);
        productName = getIntent().getStringExtra("productName");
        ProductDescription = getIntent().getStringExtra("productDescription");
        ProductPrice = getIntent().getStringExtra("productPrice");
        id = getIntent().getStringExtra("productID");
        Lat = getIntent().getStringExtra("productLac");
        Long = getIntent().getStringExtra("productLong");
        image =getIntent().getStringExtra("productImage");
        name = (EditText)findViewById(R.id.editProductName);
        desc = (EditText)findViewById(R.id.editProductDescription);
        price = (EditText)findViewById(R.id.editProductPrice);
        location = (EditText)findViewById(R.id.editProductLocation);
       // Toast.makeText(getApplicationContext(),id,Toast.LENGTH_LONG).show();

        name.setText(productName);
        desc.setText(ProductDescription);
        price.setText(ProductPrice);
        location.setText(Lat+" "+Long);

    }

    public void EditAdvertismentButton(View view) {
        if(view.getId()==R.id.editAdvBack){
            finish();
        }else{
           // Toast.makeText(getApplicationContext(),"Here2",Toast.LENGTH_LONG).show();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, UPDATE_PRODUCTS,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (!response.toString().isEmpty())
                            {
                                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
                                finish();
                            }
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
                    params.put("productDescription",desc.getText().toString());
                    params.put("productID", id);
                    params.put("productName",name.getText().toString());
                    params.put("productPrice",price.getText().toString());
                    params.put("productLocation",location.getText().toString());
                    return params;
                }

            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }


    }
}
