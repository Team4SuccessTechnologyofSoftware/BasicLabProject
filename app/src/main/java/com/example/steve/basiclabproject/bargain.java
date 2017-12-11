package com.example.steve.basiclabproject;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class bargain extends AppCompatActivity {
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bargain);

        TextView bargTitle = (TextView) findViewById(R.id.bargTitle);
        TextView bargDescr = (TextView) findViewById(R.id.bargDescr);
        TextView bargPrice = (TextView) findViewById(R.id.bargPrice);
        TextView bargDetails= (TextView) findViewById(R.id.bargDetails);
        ImageView bargImage= (ImageView) findViewById(R.id.bargImage);

        try {
            JSONObject obj = new JSONObject(getIntent().getStringExtra("Title"));
            //Toast.makeText(bargain.this,"obj: "+obj,Toast.LENGTH_LONG).show();
            bargTitle.setText(obj.getString("ProductName"));
            bargDescr.setText(obj.getString("Description"));
            bargPrice.setText(obj.getString("price")+" Euros");
        } catch (JSONException e) {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            dialogBuilder.setMessage( "error: "+e.getLocalizedMessage());
            dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            //Toast.makeText(buyActivity.this, "Unable to fetch data: " + volleyError.getMessage(), Toast.LENGTH_SHORT).show();
            AlertDialog alertDialog= dialogBuilder.create();
            alertDialog.show();
        }
    }
}
