package com.example.steve.basiclabproject;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.*;

/**
 * Created by freaksoul on 26/10/2017.
 */
@RunWith(AndroidJUnit4.class)
public class welcomeScreenActivityUITest {

    @Rule
  public   ActivityTestRule<welcomeScreenActivity> mActivity= new ActivityTestRule<welcomeScreenActivity>(welcomeScreenActivity.class);
public welcomeScreenActivity act;

    @Before
    public void setUp() throws Exception {
        //kataxwrw thn activity pou me endiaferei
act= mActivity.getActivity();
    }

    @After
    public void tearDown() throws Exception {
act=null;
    }

    @Test
    public void TestBasicUIComponents() {
        assertNotNull(act.findViewById(R.id.imageView));
        assertNotNull(act.findViewById(R.id.buttonGroupView));

    }

    @Test
    public void TestButtonInsideLayouts(){
        assertNotNull(act.findViewById(R.id.exitButton));
        assertNotNull(act.findViewById(R.id.signUpButton));
        assertNotNull(act.findViewById(R.id.loginButton));
        assertNotNull(act.findViewById(R.id.faceBookButton));

    }


}