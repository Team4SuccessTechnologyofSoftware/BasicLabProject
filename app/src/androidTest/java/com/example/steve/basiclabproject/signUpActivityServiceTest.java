package com.example.steve.basiclabproject;

import android.os.IBinder;
import android.support.test.espresso.Root;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import junit.framework.Assert;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.net.sip.SipErrorCode.TIME_OUT;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static java.lang.Thread.sleep;
import static net.bytebuddy.jar.asm.commons.GeneratorAdapter.AND;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

/**
 * Created by freaksoul on 28/10/2017.
 */
@RunWith(AndroidJUnit4.class)
public class signUpActivityServiceTest {

    @Rule
  public   ActivityTestRule<signUpActivity> sAct= new ActivityTestRule<signUpActivity>(signUpActivity.class);
   public signUpActivity activ;

    @Before
    public void setUp() throws Exception {
 activ= sAct.getActivity();
    }

    @After
    public void tearDown() throws Exception {
activ= null;
    }

    //dokimastika dedomena perimenontas to katallilo minima
    @Test
    public void onClick() throws Exception {
        EnterDataAndPressSignUpButton("TrialUsers","1234","MyFirstName","MyLastName","MyEmail@email.com","698989898989");
        onView(withId(R.id.btnSignUp)).perform(click());
        onView(withText(endsWith("registered"))).check(matches(isDisplayed()));

    }

    public boolean EnterDataAndPressSignUpButton(String username, String password, String firstName, String lastName, String Email, String Phone){
        onView(withId(R.id.eTUserName)).perform(typeText(username), closeSoftKeyboard());
        onView(withId(R.id.eTPassword)).perform(typeText(password), closeSoftKeyboard());
        onView(withId(R.id.eTFirstName)).perform(typeText(firstName), closeSoftKeyboard());
        onView(withId(R.id.eTLastName)).perform(typeText(lastName), closeSoftKeyboard());
        onView(withId(R.id.eTEmail)).perform(typeText(Email), closeSoftKeyboard());
        onView(withId(R.id.eTPhoneNumber)).perform(typeText(Phone), closeSoftKeyboard());
        onView(withId(R.id.btnSignUp)).perform(click());
        return true;
    }

}