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
import static org.junit.Assert.*;

/**
 * Created by Ion on 19/12/2017.
 */
@RunWith(AndroidJUnit4.class)
public class welcomeScreenActivityUITest {
    @Rule
    public ActivityTestRule<welcomeScreenActivity> sAct = new ActivityTestRule<welcomeScreenActivity>(welcomeScreenActivity.class);
    public welcomeScreenActivity act1;

    @Before
    public void setUp() throws Exception {
        act1 = sAct.getActivity();

    }

    @After
    public void tearDown() throws Exception {
        act1 = null;

    }

    @Test
    public void onClick() throws Exception {
        onView(withId(R.id.serchButton)).perform(click());
        //onView(withId(R.id.buttonGroupView)).perform(click());

    }

}
