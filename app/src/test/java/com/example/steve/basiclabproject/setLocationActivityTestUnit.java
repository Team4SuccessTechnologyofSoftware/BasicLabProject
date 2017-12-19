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
public class setLocationActivityTestUnit {
    private setLocationActivity act3;
    private Button sendLocData;


    @Before
    public void setUp() throws Exception {
        act3 = Robolectric.buildActivity(setLocationActivity.class)
                .create()
                .resume()
                .get();

        sendLocData = (Button)act3.findViewById(R.id.sendLocData);
    }

    @After
    public void tearDown() throws Exception {
        act3 = null;

    }

    @Test
    public void activitycheckOnClick() {
        act3.findViewById(R.id.sendLocData).performClick();
        ShadowActivity shadowActivity = Shadows.shadowOf(act3);
        Intent actualIntent = shadowActivity.getNextStartedActivity();

    }
}