package com.example.steve.basiclabproject;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

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
    }

    @After
    public void tearDown() throws Exception {
signInAct=null;
    }

}