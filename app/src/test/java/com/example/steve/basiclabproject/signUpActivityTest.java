package com.example.steve.basiclabproject;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.*;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by root on 15/12/2017.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 25)
public class signUpActivityTest {
    private signUpActivity activity;
    private welcomeScreenActivity befActivity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity( signUpActivity.class )
                .create()
                .resume()
                .get();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void onCreate() throws Exception {
        assertNotNull(activity);
        EditText username = (EditText) activity.findViewById(R.id.eTUserName);
        int topMargin = ((RelativeLayout.LayoutParams) username.getLayoutParams()).topMargin;
        String hint = (String) username.getHint();
        assertEquals("UserName", hint);
        assertEquals(20, topMargin);
        EditText firstName = (EditText) activity.findViewById(R.id.eTFirstName);
        topMargin =  ((RelativeLayout.LayoutParams) username.getLayoutParams()).topMargin;
        hint = (String) firstName.getHint();
        assertEquals("FirstName", hint);
        assertEquals(20, topMargin);
        EditText lastName = (EditText) activity.findViewById(R.id.eTLastName);
        topMargin = ((RelativeLayout.LayoutParams) lastName.getLayoutParams()).topMargin;
        hint = (String) lastName.getHint();
        assertEquals("LastName", hint);
        assertEquals(20,topMargin);
        EditText email = (EditText) activity.findViewById(R.id.eTEmail);
        topMargin = ((RelativeLayout.LayoutParams) lastName.getLayoutParams()).topMargin;
        hint = (String) email.getHint();
        assertEquals("Email", hint);
        assertEquals(20,topMargin);
        EditText phone = (EditText) activity.findViewById(R.id.eTPhoneNumber);
        topMargin = ((RelativeLayout.LayoutParams) lastName.getLayoutParams()).topMargin;
        hint = (String) phone.getHint();
        assertEquals("PhoneNumber", hint);
        assertEquals(20,topMargin);
        EditText password = (EditText) activity.findViewById(R.id.eTPassword);
        topMargin = ((RelativeLayout.LayoutParams) lastName.getLayoutParams()).topMargin;
        hint = (String) password.getHint();
        int inputType = password.getInputType();
        assertEquals(129,inputType);
        assertEquals("Password",hint);
        assertEquals(20,topMargin);

    }


    @Test
    public void onClick() throws Exception {
        EditText username = (EditText) activity.findViewById(R.id.eTUserName);
        EditText password = (EditText) activity.findViewById(R.id.eTPassword);
        EditText email = (EditText) activity.findViewById(R.id.eTEmail);
        EditText last = (EditText) activity.findViewById(R.id.eTLastName);
        EditText first = (EditText) activity.findViewById(R.id.eTFirstName);
        EditText phone = (EditText) activity.findViewById(R.id.eTPhoneNumber);
        Button btnSignUp = (Button) activity.findViewById(R.id.btnSignUp);
        username.setText(" Teo ");
        String userNameVar = username.getText().toString().trim();
        assertEquals("Teo",userNameVar);
        password.setText(" Teo*/&P ");
        String passwordVar = password.getText().toString().trim();
        assertEquals("Teo*/&P",passwordVar);
        email.setText(" Teo@gmail.com      ");
        String emailVar = email.getText().toString().trim();
        assertEquals("Teo@gmail.com",emailVar);
        last.setText(" Teodoris    ");
        String lastVar = last.getText().toString().trim();
        assertEquals("Teodoris",lastVar);
        first.setText("                   Teo  ");
        String firstVar = first.getText().toString().trim();
        assertEquals("Teo",firstVar);
        phone.setText("   8768243                      ");
        String phoneVar=phone.getText().toString().trim();
        assertEquals("8768243",phoneVar);

    }

}