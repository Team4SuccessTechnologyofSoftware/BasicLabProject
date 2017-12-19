package com.example.steve.basiclabproject;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.wifi.WifiManager;
import android.nfc.Tag;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
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
import org.robolectric.shadows.ShadowListView;
import org.robolectric.shadows.ShadowToast;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by Firnen on 17/12/2017.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class,sdk = 24)
public class advertsUnitTest {
    private newSellScreen ACT1;
    private ListView advertisements;
    @Before
    public void setUp() throws Exception {
        ACT1 = Robolectric.buildActivity(newSellScreen.class)
                .create()
                .resume()
                .get();
    }
    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(ACT1);
        assertNull(advertisements);
    }
}
