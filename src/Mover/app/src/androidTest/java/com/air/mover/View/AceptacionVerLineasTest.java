package com.air.mover.View;


import android.support.test.espresso.DataInteraction;
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

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AceptacionVerLineasTest {

    @Rule
    public ActivityTestRule<SplashScreen> mActivityTestRule = new ActivityTestRule<>(SplashScreen.class);

    @Test
    public void mostrarLineas() {
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

        ViewInteraction textView11 = onView(
                allOf(withId(R.id.textViewNumero), withText("12"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        5),
                                1),
                        isDisplayed()));
        textView11.check(matches(withText("12")));

        ViewInteraction textView12 = onView(
                allOf(withId(R.id.textViewName), withText("CARREFOUR-CANALEJAS"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        5),
                                2),
                        isDisplayed()));
        textView12.check(matches(withText("CARREFOUR-CANALEJAS")));

        ViewInteraction textView13 = onView(
                allOf(withId(R.id.textViewNumero), withText("13"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        6),
                                1),
                        isDisplayed()));
        textView13.check(matches(withText("13")));

        ViewInteraction textView14 = onView(
                allOf(withId(R.id.textViewName), withText("LLUJA-CUETO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        6),
                                2),
                        isDisplayed()));
        textView14.check(matches(withText("LLUJA-CUETO")));

        ViewInteraction textView15 = onView(
                allOf(withId(R.id.textViewNumero), withText("14"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        7),
                                1),
                        isDisplayed()));
        textView15.check(matches(withText("14")));

        ViewInteraction textView16 = onView(
                allOf(withId(R.id.textViewName), withText("ESTACIONES-AV. VALDECILLA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        7),
                                2),
                        isDisplayed()));
        textView16.check(matches(withText("ESTACIONES-AV. VALDECILLA")));

        ViewInteraction textView17 = onView(
                allOf(withId(R.id.textViewNumero), withText("15"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        8),
                                1),
                        isDisplayed()));
        textView17.check(matches(withText("15")));

        ViewInteraction textView18 = onView(
                allOf(withId(R.id.textViewName), withText("ESTACIONES-EL FARO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        8),
                                2),
                        isDisplayed()));
        textView18.check(matches(withText("ESTACIONES-EL FARO")));


        DataInteraction relativeLayout = onData(anything())
                .inAdapterView(allOf(withId(android.R.id.list),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(9);
        relativeLayout.perform(swipeDown());

        ViewInteraction textView19 = onView(
                allOf(withId(R.id.textViewNumero), withText("16"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        1),
                                1),
                        isDisplayed()));
        textView19.check(matches(withText("16")));

        ViewInteraction textView20 = onView(
                allOf(withId(R.id.textViewName), withText("PLAZA DE LOS REMEDIOS"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        1),
                                2),
                        isDisplayed()));
        textView20.check(matches(withText("PLAZA DE LOS REMEDIOS")));

        ViewInteraction textView21 = onView(
                allOf(withId(R.id.textViewNumero), withText("17"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        2),
                                1),
                        isDisplayed()));
        textView21.check(matches(withText("17")));

        ViewInteraction textView22 = onView(
                allOf(withId(R.id.textViewName), withText("CIRIEGO-CORBAN-ESTACIONES"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        2),
                                2),
                        isDisplayed()));
        textView22.check(matches(withText("CIRIEGO-CORBAN-ESTACIONES")));

        ViewInteraction textView23 = onView(
                allOf(withId(R.id.textViewNumero), withText("18"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        3),
                                1),
                        isDisplayed()));
        textView23.check(matches(withText("18")));

        ViewInteraction textView24 = onView(
                allOf(withId(R.id.textViewName), withText("PUERTOCHICO-MONTE"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        3),
                                2),
                        isDisplayed()));
        textView24.check(matches(withText("PUERTOCHICO-MONTE")));

        ViewInteraction textView25 = onView(
                allOf(withId(R.id.textViewNumero), withText("19"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        4),
                                1),
                        isDisplayed()));
        textView25.check(matches(withText("19")));

        ViewInteraction textView26 = onView(
                allOf(withId(R.id.textViewName), withText("ESTACIONES-RICARDO L. ARANDA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        4),
                                2),
                        isDisplayed()));
        textView26.check(matches(withText("ESTACIONES-RICARDO L. ARANDA")));

        ViewInteraction textView27 = onView(
                allOf(withId(R.id.textViewNumero), withText("20"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        5),
                                1),
                        isDisplayed()));
        textView27.check(matches(withText("20")));

        ViewInteraction textView28 = onView(
                allOf(withId(R.id.textViewName), withText("ESTACIONES-BARRIO LA TORRE"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        5),
                                2),
                        isDisplayed()));
        textView28.check(matches(withText("ESTACIONES-BARRIO LA TORRE")));

        ViewInteraction textView29 = onView(
                allOf(withId(R.id.textViewNumero), withText("21"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        6),
                                1),
                        isDisplayed()));
        textView29.check(matches(withText("21")));

        ViewInteraction textView30 = onView(
                allOf(withId(R.id.textViewName), withText("CENTRO DE SALUD-PUERTOCHICO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        6),
                                2),
                        isDisplayed()));
        textView30.check(matches(withText("CENTRO DE SALUD-PUERTOCHICO")));

        ViewInteraction textView31 = onView(
                allOf(withId(R.id.textViewNumero), withText("23"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        7),
                                1),
                        isDisplayed()));
        textView31.check(matches(withText("23")));

        ViewInteraction textView32 = onView(
                allOf(withId(R.id.textViewName), withText("ESTACIONES-CAMARREAL"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        7),
                                2),
                        isDisplayed()));
        textView32.check(matches(withText("ESTACIONES-CAMARREAL")));

        ViewInteraction textView33 = onView(
                allOf(withId(R.id.textViewNumero), withText("E30"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        8),
                                1),
                        isDisplayed()));
        textView33.check(matches(withText("E30")));

        ViewInteraction textView34 = onView(
                allOf(withId(R.id.textViewName), withText("SE ESTACIONES-FERIAS"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        8),
                                2),
                        isDisplayed()));
        textView34.check(matches(withText("SE ESTACIONES-FERIAS")));



        DataInteraction relativeLayout1 = onData(anything())
                .inAdapterView(allOf(withId(android.R.id.list),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(17);
        relativeLayout1.perform(swipeDown());

        ViewInteraction textView35 = onView(
                allOf(withId(R.id.textViewNumero), withText("E31"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        1),
                                1),
                        isDisplayed()));
        textView35.check(matches(withText("E31")));

        ViewInteraction textView36 = onView(
                allOf(withId(R.id.textViewName), withText("MANUEL LLANO-SARDINERO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        1),
                                2),
                        isDisplayed()));
        textView36.check(matches(withText("MANUEL LLANO-SARDINERO")));

        ViewInteraction textView37 = onView(
                allOf(withId(R.id.textViewNumero), withText("E1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        2),
                                1),
                        isDisplayed()));
        textView37.check(matches(withText("E1")));

        ViewInteraction textView38 = onView(
                allOf(withId(R.id.textViewName), withText("VALDECILLA-GREGORIO MARAÑON"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        2),
                                2),
                        isDisplayed()));
        textView38.check(matches(withText("VALDECILLA-GREGORIO MARAÑON")));

        ViewInteraction textView39 = onView(
                allOf(withId(R.id.textViewNumero), withText("E2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        3),
                                1),
                        isDisplayed()));
        textView39.check(matches(withText("E2")));

        ViewInteraction textView40 = onView(
                allOf(withId(R.id.textViewName), withText("S.E. INTERMODAL"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        3),
                                2),
                        isDisplayed()));
        textView40.check(matches(withText("S.E. INTERMODAL")));

        ViewInteraction textView41 = onView(
                allOf(withId(R.id.textViewNumero), withText("E3"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        4),
                                1),
                        isDisplayed()));
        textView41.check(matches(withText("E3")));

        ViewInteraction textView42 = onView(
                allOf(withId(R.id.textViewName), withText("SE MIRANDA-INSTITUTOS"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        4),
                                2),
                        isDisplayed()));
        textView42.check(matches(withText("SE MIRANDA-INSTITUTOS")));

        ViewInteraction textView43 = onView(
                allOf(withId(R.id.textViewNumero), withText("E4"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        5),
                                1),
                        isDisplayed()));
        textView43.check(matches(withText("E4")));

        ViewInteraction textView44 = onView(
                allOf(withId(R.id.textViewName), withText("SE SAN MARTIN-INSTITUTOS"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        5),
                                2),
                        isDisplayed()));
        textView44.check(matches(withText("SE SAN MARTIN-INSTITUTOS")));

        ViewInteraction textView45 = onView(
                allOf(withId(R.id.textViewNumero), withText("E5"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        6),
                                1),
                        isDisplayed()));
        textView45.check(matches(withText("E5")));

        ViewInteraction textView46 = onView(
                allOf(withId(R.id.textViewName), withText("SE C/ALTA-INSTITUTOS"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        6),
                                2),
                        isDisplayed()));
        textView46.check(matches(withText("SE C/ALTA-INSTITUTOS")));

        ViewInteraction textView47 = onView(
                allOf(withId(R.id.textViewNumero), withText("E9"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        7),
                                1),
                        isDisplayed()));
        textView47.check(matches(withText("E9")));

        ViewInteraction textView48 = onView(
                allOf(withId(R.id.textViewName), withText("SE ESTACIONES-CEMENTERIO LLUJA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        7),
                                2),
                        isDisplayed()));
        textView48.check(matches(withText("SE ESTACIONES-CEMENTERIO LLUJA")));

        ViewInteraction textView49 = onView(
                allOf(withId(R.id.textViewNumero), withText("5C1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        8),
                                1),
                        isDisplayed()));
        textView49.check(matches(withText("5C1")));

        ViewInteraction textView50 = onView(
                allOf(withId(R.id.textViewName), withText("MIRANDA/PLZ. ITALIA C1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        8),
                                2),
                        isDisplayed()));
        textView50.check(matches(withText("MIRANDA/PLZ. ITALIA C1")));


        DataInteraction relativeLayout2 = onData(anything())
                .inAdapterView(allOf(withId(android.R.id.list),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(25);
        relativeLayout2.perform(swipeUp());

        ViewInteraction textView51 = onView(
                allOf(withId(R.id.textViewNumero), withText("5C2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        1),
                                1),
                        isDisplayed()));
        textView51.check(matches(withText("5C2")));

        ViewInteraction textView52 = onView(
                allOf(withId(R.id.textViewName), withText("MIRANDA/PLZ. ITALIA C2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        1),
                                2),
                        isDisplayed()));
        textView52.check(matches(withText("MIRANDA/PLZ. ITALIA C2")));

        ViewInteraction textView53 = onView(
                allOf(withId(R.id.textViewNumero), withText("6C1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        2),
                                1),
                        isDisplayed()));
        textView53.check(matches(withText("6C1")));

        ViewInteraction textView54 = onView(
                allOf(withId(R.id.textViewName), withText("COMPLEJO C1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        2),
                                2),
                        isDisplayed()));
        textView54.check(matches(withText("COMPLEJO C1")));

        ViewInteraction textView55 = onView(
                allOf(withId(R.id.textViewNumero), withText("6C2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        3),
                                1),
                        isDisplayed()));
        textView55.check(matches(withText("6C2")));

        ViewInteraction textView56 = onView(
                allOf(withId(R.id.textViewName), withText("COMPLEJO C2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        3),
                                2),
                        isDisplayed()));
        textView56.check(matches(withText("COMPLEJO C2")));

        ViewInteraction textView57 = onView(
                allOf(withId(R.id.textViewNumero), withText("7C1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        4),
                                1),
                        isDisplayed()));
        textView57.check(matches(withText("7C1")));

        ViewInteraction textView58 = onView(
                allOf(withId(R.id.textViewName), withText("LUIS QUINTANILLA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        4),
                                2),
                        isDisplayed()));
        textView58.check(matches(withText("LUIS QUINTANILLA")));

        ViewInteraction textView59 = onView(
                allOf(withId(R.id.textViewNumero), withText("7C2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        5),
                                1),
                        isDisplayed()));
        textView59.check(matches(withText("7C2")));

        ViewInteraction textView60 = onView(
                allOf(withId(R.id.textViewName), withText("JOAQUIN BUSTAMANTE"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        5),
                                2),
                        isDisplayed()));
        textView60.check(matches(withText("JOAQUIN BUSTAMANTE")));

        ViewInteraction textView61 = onView(
                allOf(withId(R.id.textViewNumero), withText("N1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        6),
                                1),
                        isDisplayed()));
        textView61.check(matches(withText("N1")));

        ViewInteraction textView62 = onView(
                allOf(withId(R.id.textViewName), withText("CORBAN-G. ATECA por Valdenoja"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        6),
                                2),
                        isDisplayed()));
        textView62.check(matches(withText("CORBAN-G. ATECA por Valdenoja")));

        ViewInteraction textView63 = onView(
                allOf(withId(R.id.textViewNumero), withText("N2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        7),
                                1),
                        isDisplayed()));
        textView63.check(matches(withText("N2")));

        ViewInteraction textView64 = onView(
                allOf(withId(R.id.textViewName), withText("CORBAN-COMPLEJO por G. Davila"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        7),
                                2),
                        isDisplayed()));
        textView64.check(matches(withText("CORBAN-COMPLEJO por G. Davila")));

        ViewInteraction textView65 = onView(
                allOf(withId(R.id.textViewNumero), withText("N3"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        8),
                                1),
                        isDisplayed()));
        textView65.check(matches(withText("N3")));

        ViewInteraction textView66 = onView(
                allOf(withId(R.id.textViewName), withText("PEÑACASTILLO-PLAZA DE ITALIA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.list),
                                        8),
                                2),
                        isDisplayed()));
        textView66.check(matches(withText("PEÑACASTILLO-PLAZA DE ITALIA")));


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
