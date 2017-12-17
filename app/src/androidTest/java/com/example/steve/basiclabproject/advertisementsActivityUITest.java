package com.example.steve.basiclabproject;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.endsWith;
import static org.junit.Assert.assertNotNull;
import static org.mockito.AdditionalMatchers.not;

/**
 * Created by Firnen on 16/12/2017.
 */

@RunWith(AndroidJUnit4.class)
public class advertisementsActivityUITest {
    @Rule
    public ActivityTestRule<advertisementsActivity> sACT = new ActivityTestRule<advertisementsActivity>(advertisementsActivity.class);
    public advertisementsActivity act13;

    @Before
    public void setUp() throws Exception {
        act13= sACT.getActivity();
    }
    @Test
    public void componentsTestUIk() {
        assertNotNull(act13.findViewById(R.id.advertisements));
    }
    @After
    public void tearDown() throws Exception {
        act13= null;
    }

}
