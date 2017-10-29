package com.example.steve.basiclabproject;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.robolectric.Robolectric;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowToast;

import static org.junit.Assert.*;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by freaksoul on 29/10/2017.
 */
public class SignInUnitTest {

    private SignIn activity;

    private EditText username;
    private EditText password;
    private TextView usernameTv;
    private TextView passwordTv;
    private Button signinButton;
    private Button backButton;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity( SignIn.class )
                .create()
                .resume()
                .get();

       username = (EditText) activity.findViewById(R.id.TUserName);
        password = (EditText) activity.findViewById(R.id.TPassword);
        usernameTv = (TextView) activity.findViewById(R.id.UserNameSignInTextView);
        passwordTv= (TextView)activity.findViewById(R.id.PasswordSignInTextView);
        signinButton = (Button)activity.findViewById(R.id.signinButton);
        backButton= (Button)activity.findViewById(R.id.buttonBack);

    }

    @After
    public void tearDown() throws Exception {
        activity= null;

    }

    @Test
    public void onCreate() throws Exception {
        assertNotNull(username);
        assertNotNull(password);
        assertNotNull(usernameTv);
        assertNotNull(passwordTv);
        assertNotNull(signinButton);
        assertNotNull(backButton);

    }

    @Test
    public void exit() throws Exception {
        backButton.performClick();
        ShadowActivity shadowActivity= shadowOf(activity);
        assertTrue(shadowActivity.isFinishing());
    }

    @Test
    public void onClick() throws Exception {
username.setText("TeoUser");
        password.setText("Pass");
        signinButton.performClick();
        assertTrue(ShadowToast.showedToast("Connected successfully to the database!logged successfully"));
    }

}