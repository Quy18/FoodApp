package com.example.foodapp.DetailTest;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.foodapp.Activity.LoginActivity;
import com.example.foodapp.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class TestDetailActivity {
    @Rule
    public ActivityScenarioRule<LoginActivity> activityScenarioRule = new ActivityScenarioRule<>(LoginActivity.class);

    @Before
    public void before_test() throws InterruptedException {
        Espresso.onView(withId(R.id.emailEdt)).perform(typeText("test@test.com"));
        Espresso.onView(withId(R.id.passEdt)).perform(typeText("123456"));

        Espresso.pressBack();

        Espresso.onView(withId(R.id.loginBtn)).perform(click());
        Thread.sleep(3000);

        Espresso.onView(withId(R.id.bestFoodView)).perform(click());
        Thread.sleep(2000);
    }

    @Test
    public void test_displayUI(){
        Espresso.onView(withId(R.id.pic)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.titleTxt)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.priceTxt)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.descriptipnTxt)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.totalTxt)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.numTxt)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.addBtn)).check(matches(isDisplayed()));
    }

    @Test
    public void test_add_cart() throws InterruptedException {
        Espresso.onView(withId(R.id.plusBtn)).perform(click());
        Espresso.onView(withId(R.id.totalTxt)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.addBtn)).perform(click());
        Thread.sleep(2000);

        Espresso.onView(withId(R.id.backBtn)).perform(click());
        Thread.sleep(2000);

        Espresso.onView(withId(R.id.cartBtn)).perform(click());
        Thread.sleep(2000);
        Espresso.onView(withId(R.id.cartView)).check(matches(isDisplayed()));
    }
}
