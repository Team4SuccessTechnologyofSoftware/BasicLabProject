package com.example.steve.basiclabproject;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.nfc.Tag;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;
import org.robolectric.shadows.ShadowToast;

import static com.example.steve.basiclabproject.R.styleable.View;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by freaksoul on 28/10/2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class ,sdk = 24)
public class signUpActivityUnitTest {

    private signUpActivity activity;
    private Button btn;
    private Button btnBack;
    private EditText username;
    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText phone;
    private EditText password;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity( signUpActivity.class )
                .create()
                .resume()
                .get();

btnBack = (Button)activity.findViewById(R.id.btnBack);
        btnBack.performClick();

    }



    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void onCreate() throws Exception {

    }

    @Test
    public void exit() throws Exception {
        ShadowActivity shadowActivity= shadowOf(activity);
        assertTrue(shadowActivity.isFinishing());

    }

    @Test
    public void onClick() throws Exception {

                //equalTo("Connected successfully to the database!"+"Successfully registered"));
    }

}