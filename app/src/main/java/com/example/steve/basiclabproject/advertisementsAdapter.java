package com.example.steve.basiclabproject;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    private Button editButton=null,DeleteButton=null;
    private Activity activity=null;

    public advertisementsAdapter(@NonNull Context context, @NonNull ArrayList<product> objects, Activity mActivity) {
        super(context, R.layout.advertisement_custom_listview, objects);
        this.activity= mActivity;
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
                                params.put("productDescription", getItem(position).getDesc().toString());
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
                Toast.makeText(getContext(), "You pressed edit on product with desc" + getItem(position).getDesc(), Toast.LENGTH_LONG).show();

                        StringRequest stringRequest = new StringRequest(Request.Method.POST, GET_PRODUCTS_ALL,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        Toast.makeText(getContext(),response.toString(),Toast.LENGTH_LONG).show();
//                                        Intent intent = new Intent(activity,newSellScrenn.class);
//                                        intent.putExtra("productName",response.toString().split(",")[0]);
//                                        intent.putExtra("productDescription",response.toString().split(",")[1]);
//                                        intent.putExtra("productPrice",response.toString().split(",")[2]);
//                                        intent.putExtra("productLac",response.toString().split(",")[3]);
//                                        intent.putExtra("productLong",response.toString().split(",")[4]);
//                                        intent.putExtra("productImage",response.toString().split(",")[5]);
//                                        activity.startActivity(intent);
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
                                params.put("productDescription", getItem(position).getDesc().toString());
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
