package com.example.steve.basiclabproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class user_profil_screen extends AppCompatActivity {
TextView usernameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profil_screen);
        usernameTextView = (TextView) findViewById(R.id.tVUser_name);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Bundle extras= getIntent().getExtras();
                if(extras == null)
                    return;
                String myKeyUsername = extras.getString("usernamekey");
                usernameTextView.setText(myKeyUsername);
            }
        });

    }

    public void opensellActivity(View view){
        Intent intent = new Intent(user_profil_screen.this,sellActivity.class);
        intent.putExtra("usernamekey",usernameTextView.getText().toString());
        startActivity(intent);
    }

    public void openbuyActivity(View view){
        Intent intent = new Intent(user_profil_screen.this,buyActivity.class);
        intent.putExtra("usernamekey",usernameTextView.getText().toString());
        startActivity(intent);
    }
}
