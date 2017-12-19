package com.example.steve.basiclabproject;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Ion on 19/12/2017.
 */
@RunWith(AndroidJUnit4.class)
public class setLocationActivityUITest {
    @Rule
    public ActivityTestRule<setLocationActivity> sAct = new ActivityTestRule<setLocationActivity>(setLocationActivity.class);
    public setLocationActivity act2;

    @Before
    public void setUp() throws Exception {
        act2 = sAct.getActivity();

    }

    /* public void showYourFragmentInCaseYourActivityDoesntDoItAutomatically() {
        sAct.getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                // or add or however you put your fragment into your layouts
                .replace(R.id.map, new YourFragment(), YourFragment.TAG)
                .commit();
    } */

    @After
    public void tearDown() throws Exception {
        act2 = null;

    }

    @Test
    public void onClick() throws Exception {
        onView(withId(R.id.sendLocData)).perform(click());

    }
}