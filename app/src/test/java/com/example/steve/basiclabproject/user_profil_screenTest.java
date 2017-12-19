package com.example.steve.basiclabproject;

import android.content.ComponentName;
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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.*;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by root on 15/12/2017.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 25)
public class user_profil_screenTest {

    private user_profil_screen activity;
    private ShadowActivity shadowActivity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity( user_profil_screen.class )
                .create()
                .resume()
                .get();
        Button buyButton = (Button)activity.findViewById(R.id.buttonBuy);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void onCreate() throws Exception {
        assertNotNull(activity);
    }

    @Test(timeout = 5000)
    public void opensellActivity() throws Exception {
        Button sellButton = (Button) activity.findViewById(R.id.buttonSell);
        sellButton.performClick();
        ShadowActivity shadowActivity = shadowOf(activity);
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        ShadowIntent shadowIntent = shadowOf(startedIntent);
        assertTrue(shadowIntent.getIntentClass().equals(sellActivity.class));
    }

    @Test(timeout = 5000)
    public void openbuyActivity() throws Exception {
        Button buyButton = (Button) activity.findViewById(R.id.buttonBuy);
        buyButton.performClick();
        ShadowActivity shadowActivity = shadowOf(activity);
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        ShadowIntent shadowIntent = shadowOf(startedIntent);
        assertTrue(shadowIntent.getIntentClass().equals(buyActivity.class));

        }

    @Test
    public void openAdvertisemensActivity() throws Exception {
        Button advButton = (Button) activity.findViewById(R.id.buttonAdv);
        advButton.performClick();
        ShadowActivity shadowActivity = shadowOf(activity);
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        ShadowIntent shadowIntent = shadowOf(startedIntent);
        assertTrue(shadowIntent.getIntentClass().equals(advertisementsActivity.class));
    }

    @Test
    public void shouldStartBuyActivityWhenButtonIsClicked()
    {
        Button buyButton = (Button)activity.findViewById(R.id.buttonBuy);
        buyButton.performClick();
        Intent startedIntent = shadowOf(activity).getNextStartedActivity();
        ShadowIntent shadowIntent = shadowOf(startedIntent);
        assertEquals(buyActivity.class, shadowIntent.getIntentClass());
    }

    @Test
    public void shouldStartSellActivityWhenButtonIsClicked()
    {
        Button sellButton = (Button)activity.findViewById(R.id.buttonSell);
        sellButton.performClick();
        Intent startedIntent = shadowOf(activity).getNextStartedActivity();
        ShadowIntent shadowIntent = shadowOf(startedIntent);
        assertEquals(sellActivity.class, shadowIntent.getIntentClass());
    }

    @Test
    public void shouldStartAdvertismentsActivityWhenButtonIsClicked()
    {
        Button advButton = (Button)activity.findViewById(R.id.buttonAdv);
        advButton.performClick();
        Intent startedIntent = shadowOf(activity).getNextStartedActivity();
        ShadowIntent shadowIntent = shadowOf(startedIntent);
        assertEquals(advertisementsActivity.class, shadowIntent.getIntentClass());
    }

}