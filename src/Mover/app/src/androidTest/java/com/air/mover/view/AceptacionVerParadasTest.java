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
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AceptacionVerParadasTest {

    @Rule
    public ActivityTestRule<SplashScreen> mActivityTestRule = new ActivityTestRule<>(SplashScreen.class);

    @Test
    public void aceptacionVerParadasTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.navigation), isDisplayed()));
        bottomNavigationItemView.perform(click());


        ViewInteraction textView = onView(
                allOf(withId(R.id.txtNumParada), withText("499"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.lista_paradas),
                                        0),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("499")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.txtParadaName), withText("Camarreal Peñacastillo"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.lista_paradas),
                                        0),
                                1),
                        isDisplayed()));
        textView2.check(matches(withText("Camarreal Peñacastillo")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.txtNumParada), withText("500"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.lista_paradas),
                                        1),
                                0),
                        isDisplayed()));
        textView3.check(matches(withText("500")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.txtParadaName), withText("Ortega y Gasset.28"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.lista_paradas),
                                        1),
                                1),
                        isDisplayed()));
        textView4.check(matches(withText("Ortega y Gasset.28")));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.txtNumParada), withText("505"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.lista_paradas),
                                        2),
                                0),
                        isDisplayed()));
        textView5.check(matches(withText("505")));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.txtParadaName), withText("Avenida de Cantabria nº 35"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.lista_paradas),
                                        2),
                                1),
                        isDisplayed()));
        textView6.check(matches(withText("Avenida de Cantabria nº 35")));

        ViewInteraction textView7 = onView(
                allOf(withId(R.id.txtNumParada), withText("506"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.lista_paradas),
                                        3),
                                0),
                        isDisplayed()));
        textView7.check(matches(withText("506")));

        ViewInteraction textView8 = onView(
                allOf(withId(R.id.txtParadaName), withText("Avenida de Cantabria nº 76"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.lista_paradas),
                                        3),
                                1),
                        isDisplayed()));
        textView8.check(matches(withText("Avenida de Cantabria nº 76")));

        ViewInteraction textView9 = onView(
                allOf(withId(R.id.txtNumParada), withText("495"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.lista_paradas),
                                        4),
                                0),
                        isDisplayed()));
        textView9.check(matches(withText("495")));

        ViewInteraction textView10 = onView(
                allOf(withId(R.id.txtParadaName), withText("Eusebio Santamaria.2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.lista_paradas),
                                        4),
                                1),
                        isDisplayed()));
        textView10.check(matches(withText("Eusebio Santamaria.2")));

        ViewInteraction textView11 = onView(
                allOf(withId(R.id.txtNumParada), withText("496"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.lista_paradas),
                                        5),
                                0),
                        isDisplayed()));
        textView11.check(matches(withText("496")));

        ViewInteraction textView12 = onView(
                allOf(withId(R.id.txtParadaName), withText("Eusebio Santamaria"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.lista_paradas),
                                        5),
                                1),
                        isDisplayed()));
        textView12.check(matches(withText("Eusebio Santamaria")));

        ViewInteraction textView13 = onView(
                allOf(withId(R.id.txtNumParada), withText("443"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.lista_paradas),
                                        6),
                                0),
                        isDisplayed()));
        textView13.check(matches(withText("443")));

        ViewInteraction textView14 = onView(
                allOf(withId(R.id.txtParadaName), withText("El Mazo S/N"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.lista_paradas),
                                        6),
                                1),
                        isDisplayed()));
        textView14.check(matches(withText("El Mazo S/N")));

        ViewInteraction textView15 = onView(
                allOf(withId(R.id.txtNumParada), withText("447"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.lista_paradas),
                                        7),
                                0),
                        isDisplayed()));
        textView15.check(matches(withText("447")));

        ViewInteraction textView16 = onView(
                allOf(withId(R.id.txtParadaName), withText("Ojaiz 166"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.lista_paradas),
                                        7),
                                1),
                        isDisplayed()));
        textView16.check(matches(withText("Ojaiz 166")));

        ViewInteraction textView17 = onView(
                allOf(withId(R.id.txtNumParada), withText("470"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.lista_paradas),
                                        8),
                                0),
                        isDisplayed()));
        textView17.check(matches(withText("470")));

        ViewInteraction textView18 = onView(
                allOf(withId(R.id.txtParadaName), withText("General Davila. 77"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.lista_paradas),
                                        8),
                                1),
                        isDisplayed()));
        textView18.check(matches(withText("General Davila. 77")));

        ViewInteraction textView19 = onView(
                allOf(withId(R.id.txtNumParada), withText("471"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.lista_paradas),
                                        9),
                                0),
                        isDisplayed()));
        textView19.check(matches(withText("471")));

        ViewInteraction textView20 = onView(
                allOf(withId(R.id.txtParadaName), withText("Calle Arriba Fte . 103"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.lista_paradas),
                                        9),
                                1),
                        isDisplayed()));
        textView20.check(matches(withText("Calle Arriba Fte . 103")));

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
