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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by Firnen on 17/12/2017.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class,sdk = 24)
public class newSellScreenUnitTest {
    private newSellScreen ACT;
    private EditText productName;
    private EditText ProductDescription;
    private EditText ProductPrice;
    private EditText Lat;
    private Button editAdvBack;

    @Before
    public void setUp() throws Exception {
        ACT = Robolectric.buildActivity(newSellScreen.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void validateTextViewContent() {
        TextView editProductPrice = (TextView) ACT.findViewById(R.id.editProductPrice);
        TextView editProductDescription = (TextView) ACT.findViewById(R.id.editProductDescription);
        TextView editproductName = (TextView) ACT.findViewById(R.id.editProductName);
        TextView editProductLocatione = (TextView) ACT.findViewById(R.id.editProductLocation);

    }
    // Elegxei tis activities p anoigoun se authn thn periptwsh finish()
    @Test
    public void activitycheckOnClick() {
        ACT.findViewById(R.id.editAdvBack).performClick();
        ShadowActivity shadowActivity = Shadows.shadowOf(ACT);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
    }
    @Test
    public void testBitmapScaling() {
        Bitmap bitmap = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);

    }
}
