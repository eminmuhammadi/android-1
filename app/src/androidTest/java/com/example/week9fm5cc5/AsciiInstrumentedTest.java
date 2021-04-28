package com.example.week9fm5cc5;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.week9fm5cc5.helpers.GenerateAscii;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AsciiInstrumentedTest {

    private GenerateAscii generateAscii = new GenerateAscii();
    private ViewInteraction inputBox = onView(withId(R.id.inputBox));
    private ViewInteraction generateAsciiButton = onView(withId(R.id.generateAscii));
    private ViewInteraction resultText = onView(withId(R.id.resultText));

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testEmptyStatement() {
        String inputString = "";
        Integer sum = generateAscii.sum(inputString);

        generateAsciiButton.perform(click());

        resultText.check(matches(withText("Sum of ASCII = "+ sum.toString())));
    }

    @Test
    public void testHello() {
        String inputString = "hello world";
        Integer sum = generateAscii.sum(inputString);

        inputBox.perform(click());
        inputBox.perform(replaceText(inputString), closeSoftKeyboard());
        inputBox.perform(pressImeActionButton());

        generateAsciiButton.perform(click());

        resultText.check(matches(withText("Sum of ASCII = "+ sum.toString())));
    }

    @Test
    public void testCustomAlphabet() {
        String inputString = "çöəğşıü";
        Integer sum = generateAscii.sum(inputString);

        inputBox.perform(click());
        inputBox.perform(replaceText(inputString), closeSoftKeyboard());
        inputBox.perform(pressImeActionButton());

        generateAsciiButton.perform(click());

        resultText.check(matches(withText("Sum of ASCII = "+ sum.toString())));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
