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
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.endsWith;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Firnen on 16/12/2017.
 */
@RunWith(AndroidJUnit4.class)
public class newSellScreenUITest2 {
    @Rule
    public ActivityTestRule<newSellScreen> sAct= new ActivityTestRule<newSellScreen>(newSellScreen.class);
    public newSellScreen act12;

    @Before
    public void setUp() throws Exception {
        act12= sAct.getActivity();
    }
    @After
    public void tearDown() throws Exception {
        act12= null;
    }
    @Test
    public void componentsTestUIk(){
        assertNotNull(act12.findViewById(R.id.editProductName));
        assertNotNull(act12.findViewById(R.id.editProductDescription));
        assertNotNull(act12.findViewById(R.id.editProductPrice));
        assertNotNull(act12.findViewById(R.id.editProductLocation));

    }

}
