package com.example.steve.basiclabproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ADIS HP on 2/12/2017.
 */

public class advertisementsAdapter extends ArrayAdapter<product> {

    private Context mContext = null;
    private TextView desc=null;
    private static final String DELETE_PRODUCT = "https://team4success.000webhostapp.com/deleteProduct.php";
    private static final String GET_PRODUCTS_ALL = "https://team4success.000webhostapp.com/getProductsAll.php";
    private static final String GET_PRODUCTS = "https://team4success.000webhostapp.com/getProducts.php";
    private Button editButton=null,DeleteButton=null;
    private Activity activity=null;
    private ListView mListView=null;
    private SharedPreferences sharedPreferences=null;

    public advertisementsAdapter(@NonNull Context context, @NonNull ArrayList<product> objects, Activity mActivity,ListView listView) {
        super(context, R.layout.advertisement_custom_listview, objects);
        this.activity= mActivity;
        this.mListView = listView;
        sharedPreferences = activity.getSharedPreferences("sellApp", Context.MODE_PRIVATE);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
          View mView= LayoutInflater.from(getContext()).inflate(R.layout.advertisement_custom_listview,parent,false);
          desc = (TextView) mView.findViewById(R.id.SellAdvDesc);
          desc.setText(getItem(position).getDesc());
          editButton = (Button) mView.findViewById(R.id.advEditButton);
          DeleteButton = (Button) mView.findViewById(R.id.advDeleteButton);
          DeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "You pressed delete on product with desc" + getItem(position).getDesc(), Toast.LENGTH_LONG).show();
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, DELETE_PRODUCT,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        Toast.makeText(getContext(),response.toString(), Toast.LENGTH_LONG).show();
                                        ArrayList<product> mArray = new ArrayList<>();
                                        StringRequest stringRequest = new StringRequest(Request.Method.POST, GET_PRODUCTS,
                                                new Response.Listener<String>() {
                                                    @Override
                                                    public void onResponse(String response) {
                                                        if (!response.toString().isEmpty())
                                                        {
                                                            for(int i=0; i!=response.toString().split(",").length;i++){
                                                                product mProduct = new product();
                                                                mProduct.setDesc(response.toString().split(",")[i]);
                                                                mArray.add(mProduct);
                                                            }
                                                            mListView.setAdapter(new advertisementsAdapter(getContext(),mArray,activity,mListView));
                                                            mListView.deferNotifyDataSetChanged();



                                                        }
                                                    }
                                                },
                                                new Response.ErrorListener() {
                                                    @Override
                                                    public void onErrorResponse(VolleyError error) {
                                                        Toast.makeText(activity, error.toString(),Toast.LENGTH_LONG).show();
                                                    }
                                                }){
                                            @Override
                                            protected Map<String,String> getParams(){
                                                Map<String,String> params = new HashMap<String, String>();
//
                                                params.put("UserID",sharedPreferences.getString("userID",null));
                                                return params;
                                            }

                                        };
                                        RequestQueue requestQueue = Volley.newRequestQueue(activity);
                                        requestQueue.add(stringRequest);
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Toast.makeText(getContext(),error.toString(),Toast.LENGTH_LONG).show();
                                    }
                                }){
                            @Override
                            protected Map<String,String> getParams(){
                                Map<String,String> params = new HashMap<String, String>();
                                params.put("productDescription",getItem(position).getDesc());
                                return params;
                            }

                        };
                        RequestQueue requestQueue = Volley.newRequestQueue(activity);
                        requestQueue.add(stringRequest);
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        StringRequest stringRequest = new StringRequest(Request.Method.POST, GET_PRODUCTS_ALL,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                      //  Toast.makeText(getContext(),"Edot response" + response.toString(),Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(activity,newSellScreen.class);
                                        intent.putExtra("productName",response.toString().split(",")[0]);
                                        intent.putExtra("productDescription",response.toString().split(",")[1]);
                                        intent.putExtra("productPrice",response.toString().split(",")[2]);
                                        intent.putExtra("productLac",response.toString().split(",")[3]);
                                        intent.putExtra("productLong",response.toString().split(",")[4]);
                                        intent.putExtra("productImage",response.toString().split(",")[5]);
                                        intent.putExtra("productID",response.toString().split(",")[6]);
                                        activity.startActivity(intent);
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Toast.makeText(getContext(),error.toString(),Toast.LENGTH_LONG).show();
                                    }
                                }){
                            @Override
                            protected Map<String,String> getParams(){
                                Map<String,String> params = new HashMap<String, String>();
                                params.put("productDescription", getItem(position).getDesc());
                                return params;
                            }

                        };
                        RequestQueue requestQueue = Volley.newRequestQueue(activity);
                        requestQueue.add(stringRequest);
            }
        });


        return mView;
    }
}
