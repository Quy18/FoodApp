package com.example.foodapp.LoginTest;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotSelected;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.AllOf.allOf;

import android.util.Log;

import com.example.foodapp.Activity.IntroActivity;
import com.example.foodapp.Activity.LoginActivity;
import com.example.foodapp.R;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityScenarioRule<LoginActivity> signupRule = new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void test_displayUI(){
        Espresso.onView(withId(R.id.emailEdt)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.passEdt)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.loginBtn)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.signTxt)).check(matches(isDisplayed()));
    }

    @Test
    public void test_function_login() {
        Espresso.onView(withId(R.id.emailEdt)).perform(typeText("test@test.com"));
        Espresso.onView(withId(R.id.passEdt)).perform(typeText("123456"));

        Espresso.pressBack();

        Espresso.onView(withId(R.id.loginBtn)).perform(click());
        Espresso.onView(withId(R.id.main)).check(matches(isDisplayed()));
    }

    @Test
    public void test_function_login_error_email() {
        Espresso.onView(withId(R.id.passEdt)).perform(typeText("1234567"));

        Espresso.pressBack();

        Espresso.onView(withId(R.id.loginBtn)).perform(click());
        Espresso.onView(withId(R.id.main)).check(matches(isNotSelected()));
    }

    @Test
    public void test_function_login_error_pass() {
        Espresso.onView(withId(R.id.passEdt)).perform(typeText("1234567"));

        Espresso.pressBack();

        Espresso.onView(withId(R.id.loginBtn)).perform(click());
        Espresso.onView(withId(R.id.main)).check(matches(isNotSelected()));
    }
}