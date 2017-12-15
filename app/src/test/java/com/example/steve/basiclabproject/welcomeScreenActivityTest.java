package com.example.steve.basiclabproject;

import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;

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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.*;

/**
 * Created by ADIS HP on 15/12/2017.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 25)
public class welcomeScreenActivityTest {
    private welcomeScreenActivity activity;
    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity( welcomeScreenActivity.class )
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
    }

    @Test
    public void buttonClickShouldStartNewActivity() throws Exception
    {
        Button searchButton = (Button) activity.findViewById( R.id.serchButton );
        searchButton.performClick();
        Intent intent = Shadows.shadowOf(activity).peekNextStartedActivity();
        assertEquals(Searchmap.class.getCanonicalName(), intent.getComponent().getClassName());
    }

    @Test
    public void exit() throws Exception {

    }

    @Test
    public void signUp() throws Exception {

    }

    @Test
    public void onDestroy() throws Exception {

    }

    @Test
    public void sign_In() throws Exception {

    }

    @Test
    public void search() throws Exception {

    }

}