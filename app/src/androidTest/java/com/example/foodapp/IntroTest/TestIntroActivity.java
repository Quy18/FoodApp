package com.example.foodapp.IntroTest;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.foodapp.Activity.IntroActivity;
import com.example.foodapp.Activity.LoginActivity;
import com.example.foodapp.R;

import org.junit.Rule;
import org.junit.Test;

public class TestIntroActivity {
    @Rule
    public ActivityScenarioRule<IntroActivity> signupRule = new ActivityScenarioRule<>(IntroActivity.class);

    @Test
    public void test_displayUI() {
        Espresso.onView(withId(R.id.signupBtn)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.loginBtn)).check(matches(isDisplayed()));
    }

    @Test
    public void test_click_signup(){
        Espresso.onView(withId(R.id.signupBtn)).perform(click());
        Espresso.onView(withId(R.id.main)).check(matches(isDisplayed()));
    }

    @Test
    public void test_click_login(){
        Espresso.onView(withId(R.id.loginBtn)).perform(click());
        Espresso.onView(withId(R.id.main)).check(matches(isDisplayed()));
    }
}
