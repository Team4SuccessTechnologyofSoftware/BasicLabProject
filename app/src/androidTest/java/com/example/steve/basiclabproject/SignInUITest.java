package com.example.steve.basiclabproject;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.PositionAssertions.isAbove;
import static android.support.test.espresso.assertion.PositionAssertions.isBelow;
import static android.support.test.espresso.assertion.PositionAssertions.isLeftOf;
import static android.support.test.espresso.assertion.PositionAssertions.isRightOf;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by freaksoul on 28/10/2017.
 */
@RunWith(AndroidJUnit4.class)
public class SignInUITest {

    @Rule
   public ActivityTestRule<SignIn> sAct= new ActivityTestRule<SignIn>(SignIn.class);
    public SignIn signInAct;

    @Before
    public void setUp() throws Exception {
signInAct=sAct.getActivity();
    }

    @Test
    public void componentsTestSignInUI(){
        assertNotNull(signInAct.findViewById(R.id.UserNameSignInTextView));
        assertNotNull(signInAct.findViewById(R.id.PasswordSignInTextView));
        assertNotNull(signInAct.findViewById(R.id.TUserName));
        assertNotNull(signInAct.findViewById(R.id.TPassword));
        assertNotNull(signInAct.findViewById(R.id.buttonBack));
        assertNotNull(signInAct.findViewById(R.id.signinButton));
        onView(withId(R.id.UserNameSignInTextView)).check(isAbove(withId(R.id.PasswordSignInTextView)));
        onView(withId(R.id.TUserName)).check(isAbove(withId(R.id.TPassword)));
        onView(withId(R.id.signinButton)).check(isRightOf(withId(R.id.buttonBack)));
    }

    @After
    public void tearDown() throws Exception {
signInAct=null;
    }

}