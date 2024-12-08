package com.example.foodapp.MainTest;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.foodapp.Activity.IntroActivity;
import com.example.foodapp.Activity.LoginActivity;
import com.example.foodapp.Activity.MainActivity;
import com.example.foodapp.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class TestMainActivity {
    @Rule
    public ActivityScenarioRule<LoginActivity> signupRule = new ActivityScenarioRule<>(LoginActivity.class);

    @Before
    public void before_test() throws InterruptedException {
        // login
        Espresso.onView(withId(R.id.emailEdt)).perform(typeText("test@test.com"));
        Espresso.onView(withId(R.id.passEdt)).perform(typeText("123456"));

        Espresso.pressBack();

        Espresso.onView(withId(R.id.loginBtn)).perform(click());
        Thread.sleep(5000);
    }

    @Test
    public void test_displayUI() throws InterruptedException {
        Espresso.onView(withId(R.id.main)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.filterBtn)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.searchBtn)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.cartBtn)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.searchEdt)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.bestFoodView)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.categoryView)).check(matches(isDisplayed()));
    }

    @Test
    public void test_search_food() throws InterruptedException {
        Espresso.onView(withId(R.id.searchEdt)).perform(typeText("Margherita"));
        Espresso.onView(withId(R.id.searchBtn)).perform(click());
        Thread.sleep(2000);
        Espresso.onView(withId(R.id.foddListView)).check(matches(isDisplayed()));
    }

    @Test
    public void test_click_cart() throws InterruptedException {
        Espresso.onView(withId(R.id.cartBtn)).perform(click());
        Thread.sleep(1000);
        Espresso.onView(withId(R.id.main)).check(matches(isDisplayed()));
    }

    @Test
    public void test_click_food() throws InterruptedException {
        Espresso.onView(withId(R.id.bestFoodView)).perform(click());
        Thread.sleep(1000);
        Espresso.onView(withId(R.id.main)).check(matches(isDisplayed()));
    }

    @Test
    public void test_click_category() throws InterruptedException {
        Espresso.onView(withId(R.id.categoryView)).perform(click());
        Thread.sleep(2000);
        Espresso.onView(withId(R.id.main)).check(matches(isDisplayed()));
    }
}
