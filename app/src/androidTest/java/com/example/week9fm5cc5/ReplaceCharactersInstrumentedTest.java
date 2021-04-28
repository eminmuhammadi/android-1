package com.example.week9fm5cc5;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.week9fm5cc5.helpers.ReplaceCharacters;

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
public class ReplaceCharactersInstrumentedTest {

    private ReplaceCharacters replaceCharacters = new ReplaceCharacters();
    private ViewInteraction inputBox = onView(withId(R.id.inputBox));
    private ViewInteraction replaceCharactersButton = onView(withId(R.id.replaceCharacters));
    private ViewInteraction resultText = onView(withId(R.id.resultText));

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testEmptyStatement() {
        String inputString = "";
        String result = replaceCharacters.generate(inputString);

        replaceCharactersButton.perform(click());

        resultText.check(matches(withText("Result = \"" + result + "\"")));
    }

    @Test
    public void testHelloWorld() {
        String inputString = "Hello World";
        String result = replaceCharacters.generate(inputString);

        inputBox.perform(click());
        inputBox.perform(replaceText(inputString), closeSoftKeyboard());
        inputBox.perform(pressImeActionButton());
        replaceCharactersButton.perform(click());

        resultText.check(matches(withText("Result = \"" + result + "\"")));
    }

    @Test
    public void testLongText() {
        String inputString = "In publishing and graphic design, Lorem ipsum is a placeholder text.";
        String result = replaceCharacters.generate(inputString);

        inputBox.perform(click());
        inputBox.perform(replaceText(inputString), closeSoftKeyboard());
        inputBox.perform(pressImeActionButton());
        replaceCharactersButton.perform(click());

        resultText.check(matches(withText("Result = \"" + result + "\"")));
    }

    @Test
    public void testCustomAlphabet() {
        String inputString = "çöəğşıü";
        String result = replaceCharacters.generate(inputString);

        inputBox.perform(click());
        inputBox.perform(replaceText(inputString), closeSoftKeyboard());
        inputBox.perform(pressImeActionButton());
        replaceCharactersButton.perform(click());

        resultText.check(matches(withText("Result = \"" + result + "\"")));
    }

    @Test
    public void testWithNumbers() {
        String inputString = "0123456789";
        String result = replaceCharacters.generate(inputString);

        inputBox.perform(click());
        inputBox.perform(replaceText(inputString), closeSoftKeyboard());
        inputBox.perform(pressImeActionButton());
        replaceCharactersButton.perform(click());

        resultText.check(matches(withText("Result = \"" + result + "\"")));
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
