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
public class signUpActivityUITest {

    @Rule
    public ActivityTestRule<signUpActivity> mActivity= new ActivityTestRule<signUpActivity>(signUpActivity.class);
    public signUpActivity act;

    @Before
    public void setUp() throws Exception {
act= mActivity.getActivity();
    }

    @Test
    public void componentsTestUI(){
        assertNotNull(act.findViewById(R.id.eTUserName));
        assertNotNull(act.findViewById(R.id.eTFirstName));
        assertNotNull(act.findViewById(R.id.eTLastName));
        assertNotNull(act.findViewById(R.id.eTEmail));
        assertNotNull(act.findViewById(R.id.eTPhoneNumber));
        assertNotNull(act.findViewById(R.id.eTPassword));
        assertNotNull(act.findViewById(R.id.btnSignUp));
        assertNotNull(act.findViewById(R.id.btnBack));
    }

    @After
    public void tearDown() throws Exception {
act=null;
    }

}