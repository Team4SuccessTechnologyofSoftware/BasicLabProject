package com.example.steve.basiclabproject;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.wifi.WifiManager;
import android.nfc.Tag;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
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

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by Ion on 17/12/2017.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class,sdk = 24)
public class welcomeScreenActivityTestUnit {
    private welcomeScreenActivity act2;
    private Button serchButton;
    private Button buttonGroupView;


    @Before
    public void setUp() throws Exception {
        act2 = Robolectric.buildActivity(welcomeScreenActivity.class)
                .create()
                .resume()
                .get();
    }
    @After
    public void tearDown() throws Exception {
        act2 = null;
    }
    @Test
    public void activitycheckOnClick() {
        act2.findViewById(R.id.serchButton).performClick();
        ShadowActivity shadowActivity = Shadows.shadowOf(act2);
        Intent actualIntent = shadowActivity.getNextStartedActivity();

        act2.findViewById(R.id.buttonGroupView).performClick();
        ShadowActivity shadowActivity2 = Shadows.shadowOf(act2);
        Intent actualIntent2 = shadowActivity.getNextStartedActivity();

        act2.findViewById(R.id.buttonGroupView).performClick();
        ShadowActivity shadowActivity3 = Shadows.shadowOf(act2);
        Intent actualIntent3 = shadowActivity.getNextStartedActivity();
    }
}