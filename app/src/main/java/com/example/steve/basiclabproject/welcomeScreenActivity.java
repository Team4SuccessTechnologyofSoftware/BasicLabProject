package com.example.steve.basiclabproject;

import android.content.Intent;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class welcomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcomescreenactivity);
    }

    public void exit(View view){
       finish();
    }

    public void signUp(View view){
        Intent intent= new Intent(welcomeScreenActivity.this,signUpActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        Process.killProcess(Process.myPid());
        super.onDestroy();
    }
}
