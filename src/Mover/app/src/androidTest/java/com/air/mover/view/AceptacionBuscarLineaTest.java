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
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AceptacionBuscarLineaTest {

    @Rule
    public ActivityTestRule<SplashScreen> mActivityTestRule = new ActivityTestRule<>(SplashScreen.class);

    @Test
    public void aceptacionBuscarLineaTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.search_button), withContentDescription("Search"),
                        childAtPosition(
                                allOf(withId(R.id.search_bar),
                                        childAtPosition(
                                                withId(R.id.searchViewLinea),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageView.perform(click());

        ViewInteraction searchAutoComplete = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete.perform(replaceText("12"), closeSoftKeyboard());

        ViewInteraction textView = onView(
                allOf(withId(R.id.textViewNumero), withText("12"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                1),
                        isDisplayed()));
        textView.check(matches(withText("12")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.textViewName), withText("CARREFOUR-CANALEJAS"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                2),
                        isDisplayed()));
        textView2.check(matches(withText("CARREFOUR-CANALEJAS")));

        ViewInteraction appCompatImageView2 = onView(
                allOf(withId(R.id.search_close_btn), withContentDescription("Clear query"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                1),
                        isDisplayed()));
        appCompatImageView2.perform(click());

        ViewInteraction searchAutoComplete2 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete2.perform(click());

        ViewInteraction searchAutoComplete3 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete3.perform(replaceText("50"), closeSoftKeyboard());

        ViewInteraction linearLayout = onView(
                allOf(childAtPosition(
                        allOf(withId(android.R.id.tabcontent),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout.check(matches(isDisplayed()));

        ViewInteraction appCompatImageView3 = onView(
                allOf(withId(R.id.search_close_btn), withContentDescription("Clear query"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                1),
                        isDisplayed()));
        appCompatImageView3.perform(click());

        ViewInteraction searchAutoComplete4 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete4.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.textViewNumero), withText("15"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                1),
                        isDisplayed()));
        textView3.check(matches(withText("15")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.textViewName), withText("ESTACIONES-EL FARO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                2),
                        isDisplayed()));
        textView4.check(matches(withText("ESTACIONES-EL FARO")));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.textViewNumero), withText("E5"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        1),
                                1),
                        isDisplayed()));
        textView5.check(matches(withText("E5")));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.textViewName), withText("SE C/ALTA-INSTITUTOS"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        1),
                                2),
                        isDisplayed()));
        textView6.check(matches(withText("SE C/ALTA-INSTITUTOS")));

        ViewInteraction textView7 = onView(
                allOf(withId(R.id.textViewNumero), withText("5C1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        2),
                                1),
                        isDisplayed()));
        textView7.check(matches(withText("5C1")));

        ViewInteraction textView8 = onView(
                allOf(withId(R.id.textViewName), withText("MIRANDA/PLZ. ITALIA C1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        2),
                                2),
                        isDisplayed()));
        textView8.check(matches(withText("MIRANDA/PLZ. ITALIA C1")));

        ViewInteraction textView9 = onView(
                allOf(withId(R.id.textViewNumero), withText("5C2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        3),
                                1),
                        isDisplayed()));
        textView9.check(matches(withText("5C2")));

        ViewInteraction textView10 = onView(
                allOf(withId(R.id.textViewName), withText("MIRANDA/PLZ. ITALIA C2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        3),
                                2),
                        isDisplayed()));
        textView10.check(matches(withText("MIRANDA/PLZ. ITALIA C2")));

        ViewInteraction searchAutoComplete5 = onView(
                allOf(withId(R.id.search_src_text), withText("5"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete5.perform(replaceText("5C"));

        ViewInteraction searchAutoComplete6 = onView(
                allOf(withId(R.id.search_src_text), withText("5C"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete6.perform(closeSoftKeyboard());

        ViewInteraction textView11 = onView(
                allOf(withId(R.id.textViewNumero), withText("5C1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                1),
                        isDisplayed()));
        textView11.check(matches(withText("5C1")));

        ViewInteraction textView12 = onView(
                allOf(withId(R.id.textViewName), withText("MIRANDA/PLZ. ITALIA C1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                2),
                        isDisplayed()));
        textView12.check(matches(withText("MIRANDA/PLZ. ITALIA C1")));

        ViewInteraction textView13 = onView(
                allOf(withId(R.id.textViewNumero), withText("5C2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        1),
                                1),
                        isDisplayed()));
        textView13.check(matches(withText("5C2")));

        ViewInteraction textView14 = onView(
                allOf(withId(R.id.textViewName), withText("MIRANDA/PLZ. ITALIA C2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        1),
                                2),
                        isDisplayed()));
        textView14.check(matches(withText("MIRANDA/PLZ. ITALIA C2")));

        ViewInteraction searchAutoComplete7 = onView(
                allOf(withId(R.id.search_src_text), withText("5C"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete7.perform(click());

        ViewInteraction searchAutoComplete8 = onView(
                allOf(withId(R.id.search_src_text), withText("5C"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete8.perform(replaceText("5C1"));

        ViewInteraction searchAutoComplete9 = onView(
                allOf(withId(R.id.search_src_text), withText("5C1"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete9.perform(closeSoftKeyboard());

        ViewInteraction textView15 = onView(
                allOf(withId(R.id.textViewNumero), withText("5C1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                1),
                        isDisplayed()));
        textView15.check(matches(withText("5C1")));

        ViewInteraction textView16 = onView(
                allOf(withId(R.id.textViewName), withText("MIRANDA/PLZ. ITALIA C1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                2),
                        isDisplayed()));
        textView16.check(matches(withText("MIRANDA/PLZ. ITALIA C1")));

        ViewInteraction appCompatImageView4 = onView(
                allOf(withId(R.id.search_close_btn), withContentDescription("Clear query"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                1),
                        isDisplayed()));
        appCompatImageView4.perform(click());

        ViewInteraction searchAutoComplete10 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete10.perform(click());

        ViewInteraction searchAutoComplete11 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete11.perform(replaceText("PLAZA DE LOS REMEDIOS"), closeSoftKeyboard());

        ViewInteraction textView17 = onView(
                allOf(withId(R.id.textViewNumero), withText("16"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                1),
                        isDisplayed()));
        textView17.check(matches(withText("16")));

        ViewInteraction textView18 = onView(
                allOf(withId(R.id.textViewName), withText("PLAZA DE LOS REMEDIOS"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                2),
                        isDisplayed()));
        textView18.check(matches(withText("PLAZA DE LOS REMEDIOS")));

        ViewInteraction appCompatImageView5 = onView(
                allOf(withId(R.id.search_close_btn), withContentDescription("Clear query"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                1),
                        isDisplayed()));
        appCompatImageView5.perform(click());

        ViewInteraction searchAutoComplete12 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete12.perform(replaceText("Ojaiz-piquio"), closeSoftKeyboard());

        ViewInteraction textView19 = onView(
                allOf(withId(R.id.textViewNumero), withText("3"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                1),
                        isDisplayed()));
        textView19.check(matches(withText("3")));

        ViewInteraction textView20 = onView(
                allOf(withId(R.id.textViewName), withText("OJAIZ-PIQUIO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                2),
                        isDisplayed()));
        textView20.check(matches(withText("OJAIZ-PIQUIO")));

        ViewInteraction appCompatImageView6 = onView(
                allOf(withId(R.id.search_close_btn), withContentDescription("Clear query"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                1),
                        isDisplayed()));
        appCompatImageView6.perform(click());

        ViewInteraction searchAutoComplete13 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete13.perform(replaceText("PcTcAn-VaLdEnOjA"), closeSoftKeyboard());

        ViewInteraction textView21 = onView(
                allOf(withId(R.id.textViewNumero), withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                1),
                        isDisplayed()));
        textView21.check(matches(withText("1")));

        ViewInteraction textView22 = onView(
                allOf(withId(R.id.textViewName), withText("PCTCAN-VALDENOJA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                2),
                        isDisplayed()));
        textView22.check(matches(withText("PCTCAN-VALDENOJA")));

        ViewInteraction appCompatImageView7 = onView(
                allOf(withId(R.id.search_close_btn), withContentDescription("Clear query"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                1),
                        isDisplayed()));
        appCompatImageView7.perform(click());

        ViewInteraction searchAutoComplete14 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete14.perform(replaceText("V"), closeSoftKeyboard());


        ViewInteraction textView23 = onView(
                allOf(withId(R.id.textViewNumero), withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                1),
                        isDisplayed()));
        textView23.check(matches(withText("1")));

        ViewInteraction textView24 = onView(
                allOf(withId(R.id.textViewName), withText("PCTCAN-VALDENOJA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                2),
                        isDisplayed()));
        textView24.check(matches(withText("PCTCAN-VALDENOJA")));

        ViewInteraction textView25 = onView(
                allOf(withId(R.id.textViewNumero), withText("11"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        1),
                                1),
                        isDisplayed()));
        textView25.check(matches(withText("11")));

        ViewInteraction textView26 = onView(
                allOf(withId(R.id.textViewName), withText("VALDECILLA-C/ ALTA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        1),
                                2),
                        isDisplayed()));
        textView26.check(matches(withText("VALDECILLA-C/ ALTA")));

        ViewInteraction textView27 = onView(
                allOf(withId(R.id.textViewNumero), withText("14"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        2),
                                1),
                        isDisplayed()));
        textView27.check(matches(withText("14")));

        ViewInteraction textView28 = onView(
                allOf(withId(R.id.textViewName), withText("ESTACIONES-AV. VALDECILLA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        2),
                                2),
                        isDisplayed()));
        textView28.check(matches(withText("ESTACIONES-AV. VALDECILLA")));

        ViewInteraction textView29 = onView(
                allOf(withId(R.id.textViewNumero), withText("E1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        3),
                                1),
                        isDisplayed()));
        textView29.check(matches(withText("E1")));

        ViewInteraction textView30 = onView(
                allOf(withId(R.id.textViewName), withText("VALDECILLA-GREGORIO MARAÑON"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        3),
                                2),
                        isDisplayed()));
        textView30.check(matches(withText("VALDECILLA-GREGORIO MARAÑON")));

        ViewInteraction textView31 = onView(
                allOf(withId(R.id.textViewNumero), withText("N1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        4),
                                1),
                        isDisplayed()));
        textView31.check(matches(withText("N1")));

        ViewInteraction textView32 = onView(
                allOf(withId(R.id.textViewName), withText("CORBAN-G. ATECA por Valdenoja"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        4),
                                2),
                        isDisplayed()));
        textView32.check(matches(withText("CORBAN-G. ATECA por Valdenoja")));

        ViewInteraction textView33 = onView(
                allOf(withId(R.id.textViewNumero), withText("N2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        5),
                                1),
                        isDisplayed()));
        textView33.check(matches(withText("N2")));

        ViewInteraction textView34 = onView(
                allOf(withId(R.id.textViewName), withText("CORBAN-COMPLEJO por G. Davila"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        5),
                                2),
                        isDisplayed()));
        textView34.check(matches(withText("CORBAN-COMPLEJO por G. Davila")));

        ViewInteraction searchAutoComplete16 = onView(
                allOf(withId(R.id.search_src_text), withText("V"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete16.perform(replaceText("Va"));

        ViewInteraction searchAutoComplete17 = onView(
                allOf(withId(R.id.search_src_text), withText("Va"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete17.perform(closeSoftKeyboard());

        ViewInteraction textView35 = onView(
                allOf(withId(R.id.textViewNumero), withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                1),
                        isDisplayed()));
        textView35.check(matches(withText("1")));

        ViewInteraction textView36 = onView(
                allOf(withId(R.id.textViewName), withText("PCTCAN-VALDENOJA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                2),
                        isDisplayed()));
        textView36.check(matches(withText("PCTCAN-VALDENOJA")));

        ViewInteraction textView37 = onView(
                allOf(withId(R.id.textViewNumero), withText("11"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        1),
                                1),
                        isDisplayed()));
        textView37.check(matches(withText("11")));

        ViewInteraction textView38 = onView(
                allOf(withId(R.id.textViewName), withText("VALDECILLA-C/ ALTA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        1),
                                2),
                        isDisplayed()));
        textView38.check(matches(withText("VALDECILLA-C/ ALTA")));

        ViewInteraction textView39 = onView(
                allOf(withId(R.id.textViewNumero), withText("14"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        2),
                                1),
                        isDisplayed()));
        textView39.check(matches(withText("14")));

        ViewInteraction textView40 = onView(
                allOf(withId(R.id.textViewName), withText("ESTACIONES-AV. VALDECILLA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        2),
                                2),
                        isDisplayed()));
        textView40.check(matches(withText("ESTACIONES-AV. VALDECILLA")));

        ViewInteraction textView41 = onView(
                allOf(withId(R.id.textViewNumero), withText("E1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        3),
                                1),
                        isDisplayed()));
        textView41.check(matches(withText("E1")));

        ViewInteraction textView42 = onView(
                allOf(withId(R.id.textViewName), withText("VALDECILLA-GREGORIO MARAÑON"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        3),
                                2),
                        isDisplayed()));
        textView42.check(matches(withText("VALDECILLA-GREGORIO MARAÑON")));

        ViewInteraction textView43 = onView(
                allOf(withId(R.id.textViewNumero), withText("N1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        4),
                                1),
                        isDisplayed()));
        textView43.check(matches(withText("N1")));

        ViewInteraction textView44 = onView(
                allOf(withId(R.id.textViewName), withText("CORBAN-G. ATECA por Valdenoja"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        4),
                                2),
                        isDisplayed()));
        textView44.check(matches(withText("CORBAN-G. ATECA por Valdenoja")));

        ViewInteraction searchAutoComplete18 = onView(
                allOf(withId(R.id.search_src_text), withText("Va"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete18.perform(replaceText("Val"));

        ViewInteraction searchAutoComplete19 = onView(
                allOf(withId(R.id.search_src_text), withText("Val"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete19.perform(closeSoftKeyboard());

        ViewInteraction textView45 = onView(
                allOf(withId(R.id.textViewNumero), withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                1),
                        isDisplayed()));
        textView45.check(matches(withText("1")));

        ViewInteraction textView46 = onView(
                allOf(withId(R.id.textViewName), withText("PCTCAN-VALDENOJA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                2),
                        isDisplayed()));
        textView46.check(matches(withText("PCTCAN-VALDENOJA")));

        ViewInteraction textView47 = onView(
                allOf(withId(R.id.textViewNumero), withText("11"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        1),
                                1),
                        isDisplayed()));
        textView47.check(matches(withText("11")));

        ViewInteraction textView48 = onView(
                allOf(withId(R.id.textViewName), withText("VALDECILLA-C/ ALTA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        1),
                                2),
                        isDisplayed()));
        textView48.check(matches(withText("VALDECILLA-C/ ALTA")));

        ViewInteraction textView49 = onView(
                allOf(withId(R.id.textViewNumero), withText("14"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        2),
                                1),
                        isDisplayed()));
        textView49.check(matches(withText("14")));

        ViewInteraction textView50 = onView(
                allOf(withId(R.id.textViewName), withText("ESTACIONES-AV. VALDECILLA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        2),
                                2),
                        isDisplayed()));
        textView50.check(matches(withText("ESTACIONES-AV. VALDECILLA")));

        ViewInteraction textView51 = onView(
                allOf(withId(R.id.textViewNumero), withText("E1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        3),
                                1),
                        isDisplayed()));
        textView51.check(matches(withText("E1")));

        ViewInteraction textView52 = onView(
                allOf(withId(R.id.textViewName), withText("VALDECILLA-GREGORIO MARAÑON"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        3),
                                2),
                        isDisplayed()));
        textView52.check(matches(withText("VALDECILLA-GREGORIO MARAÑON")));

        ViewInteraction textView53 = onView(
                allOf(withId(R.id.textViewNumero), withText("N1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        4),
                                1),
                        isDisplayed()));
        textView53.check(matches(withText("N1")));

        ViewInteraction textView54 = onView(
                allOf(withId(R.id.textViewName), withText("CORBAN-G. ATECA por Valdenoja"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        4),
                                2),
                        isDisplayed()));
        textView54.check(matches(withText("CORBAN-G. ATECA por Valdenoja")));

        ViewInteraction searchAutoComplete20 = onView(
                allOf(withId(R.id.search_src_text), withText("Val"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete20.perform(replaceText("Vald"));

        ViewInteraction searchAutoComplete21 = onView(
                allOf(withId(R.id.search_src_text), withText("Vald"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete21.perform(closeSoftKeyboard());

        ViewInteraction textView55 = onView(
                allOf(withId(R.id.textViewNumero), withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                1),
                        isDisplayed()));
        textView55.check(matches(withText("1")));

        ViewInteraction textView56 = onView(
                allOf(withId(R.id.textViewName), withText("PCTCAN-VALDENOJA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                2),
                        isDisplayed()));
        textView56.check(matches(withText("PCTCAN-VALDENOJA")));

        ViewInteraction textView57 = onView(
                allOf(withId(R.id.textViewNumero), withText("11"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        1),
                                1),
                        isDisplayed()));
        textView57.check(matches(withText("11")));

        ViewInteraction textView58 = onView(
                allOf(withId(R.id.textViewName), withText("VALDECILLA-C/ ALTA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        1),
                                2),
                        isDisplayed()));
        textView58.check(matches(withText("VALDECILLA-C/ ALTA")));

        ViewInteraction textView59 = onView(
                allOf(withId(R.id.textViewNumero), withText("14"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        2),
                                1),
                        isDisplayed()));
        textView59.check(matches(withText("14")));

        ViewInteraction textView60 = onView(
                allOf(withId(R.id.textViewName), withText("ESTACIONES-AV. VALDECILLA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        2),
                                2),
                        isDisplayed()));
        textView60.check(matches(withText("ESTACIONES-AV. VALDECILLA")));

        ViewInteraction textView61 = onView(
                allOf(withId(R.id.textViewNumero), withText("E1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        3),
                                1),
                        isDisplayed()));
        textView61.check(matches(withText("E1")));

        ViewInteraction textView62 = onView(
                allOf(withId(R.id.textViewName), withText("VALDECILLA-GREGORIO MARAÑON"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        3),
                                2),
                        isDisplayed()));
        textView62.check(matches(withText("VALDECILLA-GREGORIO MARAÑON")));

        ViewInteraction textView63 = onView(
                allOf(withId(R.id.textViewNumero), withText("N1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        4),
                                1),
                        isDisplayed()));
        textView63.check(matches(withText("N1")));

        ViewInteraction textView64 = onView(
                allOf(withId(R.id.textViewName), withText("CORBAN-G. ATECA por Valdenoja"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        4),
                                2),
                        isDisplayed()));
        textView64.check(matches(withText("CORBAN-G. ATECA por Valdenoja")));

        ViewInteraction searchAutoComplete22 = onView(
                allOf(withId(R.id.search_src_text), withText("Vald"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete22.perform(replaceText("Valde"));

        ViewInteraction searchAutoComplete23 = onView(
                allOf(withId(R.id.search_src_text), withText("Valde"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete23.perform(closeSoftKeyboard());

        ViewInteraction textView65 = onView(
                allOf(withId(R.id.textViewNumero), withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                1),
                        isDisplayed()));
        textView65.check(matches(withText("1")));

        ViewInteraction textView66 = onView(
                allOf(withId(R.id.textViewName), withText("PCTCAN-VALDENOJA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                2),
                        isDisplayed()));
        textView66.check(matches(withText("PCTCAN-VALDENOJA")));

        ViewInteraction textView67 = onView(
                allOf(withId(R.id.textViewNumero), withText("11"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        1),
                                1),
                        isDisplayed()));
        textView67.check(matches(withText("11")));

        ViewInteraction textView68 = onView(
                allOf(withId(R.id.textViewName), withText("VALDECILLA-C/ ALTA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        1),
                                2),
                        isDisplayed()));
        textView68.check(matches(withText("VALDECILLA-C/ ALTA")));

        ViewInteraction textView69 = onView(
                allOf(withId(R.id.textViewNumero), withText("14"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        2),
                                1),
                        isDisplayed()));
        textView69.check(matches(withText("14")));

        ViewInteraction textView70 = onView(
                allOf(withId(R.id.textViewName), withText("ESTACIONES-AV. VALDECILLA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        2),
                                2),
                        isDisplayed()));
        textView70.check(matches(withText("ESTACIONES-AV. VALDECILLA")));

        ViewInteraction textView71 = onView(
                allOf(withId(R.id.textViewNumero), withText("E1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        3),
                                1),
                        isDisplayed()));
        textView71.check(matches(withText("E1")));

        ViewInteraction textView72 = onView(
                allOf(withId(R.id.textViewName), withText("VALDECILLA-GREGORIO MARAÑON"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        3),
                                2),
                        isDisplayed()));
        textView72.check(matches(withText("VALDECILLA-GREGORIO MARAÑON")));

        ViewInteraction textView73 = onView(
                allOf(withId(R.id.textViewNumero), withText("N1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        4),
                                1),
                        isDisplayed()));
        textView73.check(matches(withText("N1")));

        ViewInteraction textView74 = onView(
                allOf(withId(R.id.textViewName), withText("CORBAN-G. ATECA por Valdenoja"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        4),
                                2),
                        isDisplayed()));
        textView74.check(matches(withText("CORBAN-G. ATECA por Valdenoja")));

        ViewInteraction searchAutoComplete24 = onView(
                allOf(withId(R.id.search_src_text), withText("Valde"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete24.perform(replaceText("Valdec"));

        ViewInteraction searchAutoComplete25 = onView(
                allOf(withId(R.id.search_src_text), withText("Valdec"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete25.perform(closeSoftKeyboard());

        ViewInteraction textView75 = onView(
                allOf(withId(R.id.textViewNumero), withText("11"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                1),
                        isDisplayed()));
        textView75.check(matches(withText("11")));

        ViewInteraction textView76 = onView(
                allOf(withId(R.id.textViewName), withText("VALDECILLA-C/ ALTA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                2),
                        isDisplayed()));
        textView76.check(matches(withText("VALDECILLA-C/ ALTA")));

        ViewInteraction textView77 = onView(
                allOf(withId(R.id.textViewNumero), withText("14"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        1),
                                1),
                        isDisplayed()));
        textView77.check(matches(withText("14")));

        ViewInteraction textView78 = onView(
                allOf(withId(R.id.textViewName), withText("ESTACIONES-AV. VALDECILLA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        1),
                                2),
                        isDisplayed()));
        textView78.check(matches(withText("ESTACIONES-AV. VALDECILLA")));

        ViewInteraction textView79 = onView(
                allOf(withId(R.id.textViewNumero), withText("E1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        2),
                                1),
                        isDisplayed()));
        textView79.check(matches(withText("E1")));

        ViewInteraction textView80 = onView(
                allOf(withId(R.id.textViewName), withText("VALDECILLA-GREGORIO MARAÑON"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        2),
                                2),
                        isDisplayed()));
        textView80.check(matches(withText("VALDECILLA-GREGORIO MARAÑON")));

        ViewInteraction appCompatImageView8 = onView(
                allOf(withId(R.id.search_close_btn), withContentDescription("Clear query"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                1),
                        isDisplayed()));
        appCompatImageView8.perform(click());

        ViewInteraction searchAutoComplete26 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete26.perform(click());

        ViewInteraction searchAutoComplete27 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete27.perform(replaceText("Unican"), closeSoftKeyboard());

        ViewInteraction linearLayout2 = onView(
                allOf(childAtPosition(
                        allOf(withId(android.R.id.tabcontent),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout2.check(matches(isDisplayed()));

        ViewInteraction appCompatImageView9 = onView(
                allOf(withId(R.id.search_close_btn), withContentDescription("Clear query"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                1),
                        isDisplayed()));
        appCompatImageView9.perform(click());

        ViewInteraction searchAutoComplete28 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete28.perform(click());

        ViewInteraction searchAutoComplete29 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete29.perform(click());

        ViewInteraction searchAutoComplete30 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete30.perform(replaceText("13 LLUJA-CUETO"), closeSoftKeyboard());

        ViewInteraction textView81 = onView(
                allOf(withId(R.id.textViewNumero), withText("13"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                1),
                        isDisplayed()));
        textView81.check(matches(withText("13")));

        ViewInteraction textView82 = onView(
                allOf(withId(R.id.textViewName), withText("LLUJA-CUETO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                2),
                        isDisplayed()));
        textView82.check(matches(withText("LLUJA-CUETO")));

        ViewInteraction appCompatImageView10 = onView(
                allOf(withId(R.id.search_close_btn), withContentDescription("Clear query"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                1),
                        isDisplayed()));
        appCompatImageView10.perform(click());

        ViewInteraction searchAutoComplete31 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete31.perform(replaceText("13 UNICAN"), closeSoftKeyboard());

        ViewInteraction linearLayout3 = onView(
                allOf(childAtPosition(
                        allOf(withId(android.R.id.tabcontent),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout3.check(matches(isDisplayed()));

        ViewInteraction appCompatImageView11 = onView(
                allOf(withId(R.id.search_close_btn), withContentDescription("Clear query"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                1),
                        isDisplayed()));
        appCompatImageView11.perform(click());

        ViewInteraction searchAutoComplete32 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete32.perform(click());

        ViewInteraction searchAutoComplete33 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete33.perform(replaceText("90 PLAZA DE LOS REMEDIOS"), closeSoftKeyboard());

        ViewInteraction linearLayout4 = onView(
                allOf(childAtPosition(
                        allOf(withId(android.R.id.tabcontent),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout4.check(matches(isDisplayed()));


        ViewInteraction searchAutoComplete34 = onView(
                allOf(withId(R.id.search_src_text), withText("90 PLAZA DE LOS REMEDIOS"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete34.perform(click());


        ViewInteraction searchAutoComplete35 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete35.perform(replaceText("13 PLAZA DE LOS REMEDIOS"), closeSoftKeyboard());

        ViewInteraction linearLayout5 = onView(
                allOf(childAtPosition(
                        allOf(withId(android.R.id.tabcontent),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout5.check(matches(isDisplayed()));

        ViewInteraction appCompatImageView13 = onView(
                allOf(withId(R.id.search_close_btn), withContentDescription("Clear query"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                1),
                        isDisplayed()));
        appCompatImageView13.perform(click());

        ViewInteraction searchAutoComplete36 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete36.perform(replaceText("13  LLUJA-CUETO"), closeSoftKeyboard());

        ViewInteraction textView83 = onView(
                allOf(withId(R.id.textViewNumero), withText("13"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                1),
                        isDisplayed()));
        textView83.check(matches(withText("13")));

        ViewInteraction textView84 = onView(
                allOf(withId(R.id.textViewName), withText("LLUJA-CUETO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        0),
                                2),
                        isDisplayed()));
        textView84.check(matches(withText("LLUJA-CUETO")));

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
