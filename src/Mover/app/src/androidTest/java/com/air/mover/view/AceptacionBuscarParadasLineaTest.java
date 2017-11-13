package com.air.mover.view;


import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

import com.air.mover.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AceptacionBuscarParadasLineaTest {

    @Rule
    public ActivityTestRule<SplashScreen> mActivityTestRule = new ActivityTestRule<>(SplashScreen.class);

    @Test
    public void aceptacionBuscarParadasLineaTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        DataInteraction relativeLayout = onData(anything())
                .inAdapterView(allOf(withId(android.R.id.list),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(4);
        relativeLayout.perform(click());

        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.search_button), withContentDescription("Search"),
                        childAtPosition(
                                allOf(withId(R.id.search_bar),
                                        childAtPosition(
                                                withId(R.id.searchParadasLinea),
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
        searchAutoComplete.perform(replaceText("429"), closeSoftKeyboard());

        ViewInteraction textView = onView(
                allOf(withId(R.id.txtNumParada), withText("429"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("429")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.txtParadaName), withText("CALLE ALTA 46"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                1),
                        isDisplayed()));
        textView2.check(matches(withText("CALLE ALTA 46")));

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
        searchAutoComplete2.perform(replaceText("90"), closeSoftKeyboard());

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.listaParadasLinea),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        recyclerView.check(matches(isDisplayed()));

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

        ViewInteraction searchAutoComplete3 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete3.perform(replaceText("plaza de toros"), closeSoftKeyboard());

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.txtNumParada), withText("433"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                0),
                        isDisplayed()));
        textView3.check(matches(withText("433")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.txtParadaName), withText("PLAZA DE TOROS"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                1),
                        isDisplayed()));
        textView4.check(matches(withText("PLAZA DE TOROS")));

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

        ViewInteraction searchAutoComplete4 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete4.perform(replaceText("plazas de toros"), closeSoftKeyboard());

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.listaParadasLinea),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        recyclerView2.check(matches(isDisplayed()));

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

        ViewInteraction searchAutoComplete5 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete5.perform(replaceText("PLAZA DE TOROS"), closeSoftKeyboard());

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.txtNumParada), withText("433"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                0),
                        isDisplayed()));
        textView5.check(matches(withText("433")));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.txtParadaName), withText("PLAZA DE TOROS"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                1),
                        isDisplayed()));
        textView6.check(matches(withText("PLAZA DE TOROS")));

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

        ViewInteraction searchAutoComplete6 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete6.perform(replaceText("PLAZAS DE TOROS"), closeSoftKeyboard());

        ViewInteraction recyclerView3 = onView(
                allOf(withId(R.id.listaParadasLinea),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        recyclerView3.check(matches(isDisplayed()));

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

        ViewInteraction searchAutoComplete7 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete7.perform(replaceText("PlAzA dE tOrOs"), closeSoftKeyboard());

        ViewInteraction textView7 = onView(
                allOf(withId(R.id.txtNumParada), withText("433"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                0),
                        isDisplayed()));
        textView7.check(matches(withText("433")));

        ViewInteraction textView8 = onView(
                allOf(withId(R.id.txtParadaName), withText("PLAZA DE TOROS"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                1),
                        isDisplayed()));
        textView8.check(matches(withText("PLAZA DE TOROS")));

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

        ViewInteraction searchAutoComplete8 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete8.perform(replaceText("PlAzAs De tOrOs"), closeSoftKeyboard());

        ViewInteraction recyclerView4 = onView(
                allOf(withId(R.id.listaParadasLinea),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        recyclerView4.check(matches(isDisplayed()));

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

        ViewInteraction searchAutoComplete9 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete9.perform(replaceText("9 valdecilla"), closeSoftKeyboard());

        ViewInteraction textView9 = onView(
                allOf(withId(R.id.txtNumParada), withText("9"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                0),
                        isDisplayed()));
        textView9.check(matches(withText("9")));

        ViewInteraction textView10 = onView(
                allOf(withId(R.id.txtParadaName), withText("VALDECILLA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                1),
                        isDisplayed()));
        textView10.check(matches(withText("VALDECILLA")));

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

        ViewInteraction searchAutoComplete10 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete10.perform(replaceText("9 z"), closeSoftKeyboard());

        ViewInteraction recyclerView5 = onView(
                allOf(withId(R.id.listaParadasLinea),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        recyclerView5.check(matches(isDisplayed()));

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

        ViewInteraction searchAutoComplete11 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete11.perform(replaceText("6"), closeSoftKeyboard());

        ViewInteraction textView11 = onView(
                allOf(withId(R.id.txtNumParada), withText("268"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                0),
                        isDisplayed()));
        textView11.check(matches(withText("268")));

        ViewInteraction textView12 = onView(
                allOf(withId(R.id.txtParadaName), withText("MERCADO MEJICO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                1),
                        isDisplayed()));
        textView12.check(matches(withText("MERCADO MEJICO")));

        ViewInteraction textView13 = onView(
                allOf(withId(R.id.txtNumParada), withText("269"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        1),
                                0),
                        isDisplayed()));
        textView13.check(matches(withText("269")));

        ViewInteraction textView14 = onView(
                allOf(withId(R.id.txtParadaName), withText("CALLE ALTA 109"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        1),
                                1),
                        isDisplayed()));
        textView14.check(matches(withText("CALLE ALTA 109")));

        ViewInteraction textView15 = onView(
                allOf(withId(R.id.txtNumParada), withText("429"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        2),
                                0),
                        isDisplayed()));
        textView15.check(matches(withText("429")));

        ViewInteraction textView16 = onView(
                allOf(withId(R.id.txtParadaName), withText("CALLE ALTA 46"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        2),
                                1),
                        isDisplayed()));
        textView16.check(matches(withText("CALLE ALTA 46")));

        ViewInteraction textView17 = onView(
                allOf(withId(R.id.txtNumParada), withText("430"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        3),
                                0),
                        isDisplayed()));
        textView17.check(matches(withText("430")));

        ViewInteraction textView18 = onView(
                allOf(withId(R.id.txtParadaName), withText("CALLE ALTA 56"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        3),
                                1),
                        isDisplayed()));
        textView18.check(matches(withText("CALLE ALTA 56")));

        ViewInteraction searchAutoComplete12 = onView(
                allOf(withId(R.id.search_src_text), withText("6"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete12.perform(replaceText("68"));

        ViewInteraction searchAutoComplete13 = onView(
                allOf(withId(R.id.search_src_text), withText("68"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete13.perform(closeSoftKeyboard());

        ViewInteraction textView19 = onView(
                allOf(withId(R.id.txtNumParada), withText("268"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                0),
                        isDisplayed()));
        textView19.check(matches(withText("268")));

        ViewInteraction textView20 = onView(
                allOf(withId(R.id.txtParadaName), withText("MERCADO MEJICO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                1),
                        isDisplayed()));
        textView20.check(matches(withText("MERCADO MEJICO")));

        ViewInteraction appCompatImageView12 = onView(
                allOf(withId(R.id.search_close_btn), withContentDescription("Clear query"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                1),
                        isDisplayed()));
        appCompatImageView12.perform(click());

        ViewInteraction searchAutoComplete14 = onView(
                allOf(withId(R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete14.perform(replaceText("m"), closeSoftKeyboard());

        ViewInteraction textView21 = onView(
                allOf(withId(R.id.txtNumParada), withText("268"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                0),
                        isDisplayed()));
        textView21.check(matches(withText("268")));

        ViewInteraction textView22 = onView(
                allOf(withId(R.id.txtParadaName), withText("MERCADO MEJICO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                1),
                        isDisplayed()));
        textView22.check(matches(withText("MERCADO MEJICO")));

        ViewInteraction textView23 = onView(
                allOf(withId(R.id.txtNumParada), withText("272"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        1),
                                0),
                        isDisplayed()));
        textView23.check(matches(withText("272")));

        ViewInteraction textView24 = onView(
                allOf(withId(R.id.txtParadaName), withText("MONTE CALOCA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        1),
                                1),
                        isDisplayed()));
        textView24.check(matches(withText("MONTE CALOCA")));

        ViewInteraction textView25 = onView(
                allOf(withId(R.id.txtNumParada), withText("12"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        2),
                                0),
                        isDisplayed()));
        textView25.check(matches(withText("12")));

        ViewInteraction textView26 = onView(
                allOf(withId(R.id.txtParadaName), withText("JESUS DE MONASTERIO 21"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        2),
                                1),
                        isDisplayed()));
        textView26.check(matches(withText("JESUS DE MONASTERIO 21")));

        ViewInteraction textView27 = onView(
                allOf(withId(R.id.txtNumParada), withText("13"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        3),
                                0),
                        isDisplayed()));
        textView27.check(matches(withText("13")));

        ViewInteraction textView28 = onView(
                allOf(withId(R.id.txtParadaName), withText("AYUNTAMIENTO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        3),
                                1),
                        isDisplayed()));
        textView28.check(matches(withText("AYUNTAMIENTO")));

        ViewInteraction textView29 = onView(
                allOf(withId(R.id.txtNumParada), withText("13"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        4),
                                0),
                        isDisplayed()));
        textView29.check(matches(withText("13")));

        ViewInteraction textView30 = onView(
                allOf(withId(R.id.txtParadaName), withText("AYUNTAMIENTO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        4),
                                1),
                        isDisplayed()));
        textView30.check(matches(withText("AYUNTAMIENTO")));

        ViewInteraction searchAutoComplete15 = onView(
                allOf(withId(R.id.search_src_text), withText("m"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete15.perform(replaceText("mo"));

        ViewInteraction searchAutoComplete16 = onView(
                allOf(withId(R.id.search_src_text), withText("mo"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete16.perform(closeSoftKeyboard());

        ViewInteraction textView31 = onView(
                allOf(withId(R.id.txtNumParada), withText("272"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                0),
                        isDisplayed()));
        textView31.check(matches(withText("272")));

        ViewInteraction textView32 = onView(
                allOf(withId(R.id.txtParadaName), withText("MONTE CALOCA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                1),
                        isDisplayed()));
        textView32.check(matches(withText("MONTE CALOCA")));

        ViewInteraction textView33 = onView(
                allOf(withId(R.id.txtNumParada), withText("12"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        1),
                                0),
                        isDisplayed()));
        textView33.check(matches(withText("12")));

        ViewInteraction textView34 = onView(
                allOf(withId(R.id.txtParadaName), withText("JESUS DE MONASTERIO 21"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        1),
                                1),
                        isDisplayed()));
        textView34.check(matches(withText("JESUS DE MONASTERIO 21")));

        ViewInteraction searchAutoComplete17 = onView(
                allOf(withId(R.id.search_src_text), withText("mo"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete17.perform(replaceText("mon"));

        ViewInteraction searchAutoComplete18 = onView(
                allOf(withId(R.id.search_src_text), withText("mon"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete18.perform(closeSoftKeyboard());

        ViewInteraction textView35 = onView(
                allOf(withId(R.id.txtNumParada), withText("272"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                0),
                        isDisplayed()));
        textView35.check(matches(withText("272")));

        ViewInteraction textView36 = onView(
                allOf(withId(R.id.txtParadaName), withText("MONTE CALOCA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                1),
                        isDisplayed()));
        textView36.check(matches(withText("MONTE CALOCA")));

        ViewInteraction textView37 = onView(
                allOf(withId(R.id.txtNumParada), withText("12"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        1),
                                0),
                        isDisplayed()));
        textView37.check(matches(withText("12")));

        ViewInteraction textView38 = onView(
                allOf(withId(R.id.txtParadaName), withText("JESUS DE MONASTERIO 21"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        1),
                                1),
                        isDisplayed()));
        textView38.check(matches(withText("JESUS DE MONASTERIO 21")));

        ViewInteraction searchAutoComplete19 = onView(
                allOf(withId(R.id.search_src_text), withText("mon"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete19.perform(replaceText("mona"));

        ViewInteraction searchAutoComplete20 = onView(
                allOf(withId(R.id.search_src_text), withText("mona"),
                        childAtPosition(
                                allOf(withId(R.id.search_plate),
                                        childAtPosition(
                                                withId(R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete20.perform(closeSoftKeyboard());

        ViewInteraction textView39 = onView(
                allOf(withId(R.id.txtNumParada), withText("12"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                0),
                        isDisplayed()));
        textView39.check(matches(withText("12")));

        ViewInteraction textView40 = onView(
                allOf(withId(R.id.txtParadaName), withText("JESUS DE MONASTERIO 21"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                1),
                        isDisplayed()));
        textView40.check(matches(withText("JESUS DE MONASTERIO 21")));

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
