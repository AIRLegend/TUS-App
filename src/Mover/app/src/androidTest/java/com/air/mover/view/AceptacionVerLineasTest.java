package com.air.mover.view;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.air.mover.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AceptacionVerLineasTest {

    @Rule
    public ActivityTestRule<SplashScreen> mActivityTestRule = new ActivityTestRule<>(SplashScreen.class);

    @Test
    public void aceptacionLineasTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction textView = onView(
                allOf(withId(R.id.textViewNumero), withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                1),
                        isDisplayed()));
        textView.check(matches(withText("1")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.textViewName), withText("PCTCAN-VALDENOJA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                2),
                        isDisplayed()));
        textView2.check(matches(withText("PCTCAN-VALDENOJA")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.textViewNumero), withText("2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        1),
                                1),
                        isDisplayed()));
        textView3.check(matches(withText("2")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.textViewName), withText("CORBAN-CONSUELO BERGES"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        1),
                                2),
                        isDisplayed()));
        textView4.check(matches(withText("CORBAN-CONSUELO BERGES")));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.textViewNumero), withText("3"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        2),
                                1),
                        isDisplayed()));
        textView5.check(matches(withText("3")));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.textViewName), withText("OJAIZ-PIQUIO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        2),
                                2),
                        isDisplayed()));
        textView6.check(matches(withText("OJAIZ-PIQUIO")));

        ViewInteraction textView7 = onView(
                allOf(withId(R.id.textViewNumero), withText("4"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        3),
                                1),
                        isDisplayed()));
        textView7.check(matches(withText("4")));

        ViewInteraction textView8 = onView(
                allOf(withId(R.id.textViewName), withText("BARRIO PESQUERO-PIQUIO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        3),
                                2),
                        isDisplayed()));
        textView8.check(matches(withText("BARRIO PESQUERO-PIQUIO")));

        ViewInteraction textView9 = onView(
                allOf(withId(R.id.textViewNumero), withText("11"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        4),
                                1),
                        isDisplayed()));
        textView9.check(matches(withText("11")));

        ViewInteraction textView10 = onView(
                allOf(withId(R.id.textViewName), withText("VALDECILLA-C/ ALTA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        4),
                                2),
                        isDisplayed()));
        textView10.check(matches(withText("VALDECILLA-C/ ALTA")));

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
