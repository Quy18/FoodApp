package com.example.foodapp.SignupTest;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotSelected;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.foodapp.Activity.LoginActivity;
import com.example.foodapp.Activity.SignupActivity;
import com.example.foodapp.R;

import org.junit.Rule;
import org.junit.Test;

public class TestSignupActivity {
    @Rule
    public ActivityScenarioRule<SignupActivity> signupRule = new ActivityScenarioRule<>(SignupActivity.class);

    @Test
    public void test_displayUI(){
        Espresso.onView(withId(R.id.usernameEdt)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.emailEdt)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.passEdt)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.signupBtn)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.loginTxt)).check(matches(isDisplayed()));
    }

    @Test
    public void test_function_signup_error() throws InterruptedException {
        //tai khoan da ton tai
        Espresso.onView(withId(R.id.usernameEdt)).perform(typeText("test"));
        Espresso.onView(withId(R.id.emailEdt)).perform(typeText("test@test.com"));
        Espresso.onView(withId(R.id.passEdt)).perform(typeText("123456"));

        Espresso.pressBack();
        Espresso.onView(withId(R.id.signupBtn)).perform(click());

        Thread.sleep(1000);
        Espresso.onView(withId(R.id.main)).check(matches(isNotSelected()));
    }
}
