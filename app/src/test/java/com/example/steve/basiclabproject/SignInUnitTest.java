package com.example.steve.basiclabproject;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
import org.robolectric.shadows.ShadowToast;

import static com.google.android.gms.tasks.Tasks.await;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.*;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by root on 15/12/2017.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
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

    @Test(timeout = 5000)
    public void onClick() throws Exception {
    }

    @Test
    public void onSuccessClick() throws Exception {
        Intent startedIntent = shadowOf(activity).getNextStartedActivity();
        username.setText("TeoUser");
        password.setText("Pass");
        signinButton.performClick();
        ShadowIntent shadowIntent = shadowOf(startedIntent);
        assertEquals(user_profil_screen.class, shadowIntent.getIntentClass());
    }

    @Test
    public void onFailure() throws Exception {
        Intent startedIntent = shadowOf(activity).getNextStartedActivity();
        username.setText("TesdfasoUser");
        password.setText("Passsdfds");
        signinButton.performClick();
        ShadowIntent shadowIntent = shadowOf(startedIntent);
        assertFalse((user_profil_screen.class.equals(shadowIntent.getIntentClass())));

    }

    @Test
    public void backButtonPressed(){
        backButton.performClick();
        activity.isFinishing();
    }

}