package com.example.steve.basiclabproject;

import android.content.Intent;
import android.widget.Button;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by freaksoul on 29/10/2017.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class ,sdk = 24)

public class welcomeScreenActivityUnitTest {

    private signUpActivity activity;
    private Button btnExit;
    private Button btnSignUp;
    private Button btnLogin;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity( signUpActivity.class )
                .create()
                .resume()
                .get();

btnExit= (Button) activity.findViewById(R.id.btnBack);
        btnSignUp= (Button) activity.findViewById(R.id.btnSignUp);
        btnLogin= (Button) activity.findViewById(R.id.loginButton);
    }

    @After
    public void tearDown() throws Exception {
        activity= null;

    }

    @Test
    public void exit() throws Exception {
btnExit.performClick();
        ShadowActivity shadowActivity= shadowOf(activity);
        assertTrue(shadowActivity.isFinishing());
    }

    @Test
    public void signUp() throws Exception {
btnSignUp.performClick();
        ShadowActivity shadowActivity= shadowOf(activity);
        Intent startedIntent= shadowActivity.getNextStartedActivity();
        ShadowIntent shadowIntent= shadowOf(startedIntent);
        assertThat(shadowActivity.getNextStartedActivity().getComponent().getClassName(), equalTo(signUpActivity.class.getName()));
    }

    @Test
    public void sign_In() throws Exception {
        btnSignUp.performClick();
        ShadowActivity shadowActivity= shadowOf(activity);
        Intent startedIntent= shadowActivity.getNextStartedActivity();
        ShadowIntent shadowIntent= shadowOf(startedIntent);
        assertThat(shadowActivity.getNextStartedActivity().getComponent().getClassName(), equalTo(SignIn.class.getName()));
    }

}