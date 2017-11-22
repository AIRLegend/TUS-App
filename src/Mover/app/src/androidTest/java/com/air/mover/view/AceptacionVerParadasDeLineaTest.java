package com.air.mover.view;


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
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
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
public class AceptacionVerParadasDeLineaTest {

    @Rule
    public ActivityTestRule<SplashScreen> mActivityTestRule = new ActivityTestRule<>(SplashScreen.class);

    @Test
    public void paradasLineaAceptacion() {
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
                .atPosition(0);
        relativeLayout.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.txtNumParada), withText("328"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("328")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.txtParadaName), withText("ARSENIO ODRIOZOLA 16"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                1),
                        isDisplayed()));
        textView2.check(matches(withText("ARSENIO ODRIOZOLA 16")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.txtNumParada), withText("330"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        1),
                                0),
                        isDisplayed()));
        textView3.check(matches(withText("330")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.txtParadaName), withText("DOCTOR DIEGO MADRAZO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        1),
                                1),
                        isDisplayed()));
        textView4.check(matches(withText("DOCTOR DIEGO MADRAZO")));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.txtNumParada), withText("200"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        2),
                                0),
                        isDisplayed()));
        textView5.check(matches(withText("200")));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.txtParadaName), withText("CONSUELO BERGÉS 16"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        2),
                                1),
                        isDisplayed()));
        textView6.check(matches(withText("CONSUELO BERGÉS 16")));

        ViewInteraction textView7 = onView(
                allOf(withId(R.id.txtNumParada), withText("201"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        3),
                                0),
                        isDisplayed()));
        textView7.check(matches(withText("201")));

        ViewInteraction textView8 = onView(
                allOf(withId(R.id.txtParadaName), withText("CONCHA ESPINA 18"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        3),
                                1),
                        isDisplayed()));
        textView8.check(matches(withText("CONCHA ESPINA 18")));

        ViewInteraction textView9 = onView(
                allOf(withId(R.id.txtNumParada), withText("167"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        4),
                                0),
                        isDisplayed()));
        textView9.check(matches(withText("167")));

        ViewInteraction textView10 = onView(
                allOf(withId(R.id.txtParadaName), withText("MANUEL GONZALEZ HOYOS 39"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        4),
                                1),
                        isDisplayed()));
        textView10.check(matches(withText("MANUEL GONZALEZ HOYOS 39")));

        pressBack();

        DataInteraction relativeLayout2 = onData(anything())
                .inAdapterView(allOf(withId(android.R.id.list),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(1);
        relativeLayout2.perform(click());

        ViewInteraction textView11 = onView(
                allOf(withId(R.id.txtNumParada), withText("331"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                0),
                        isDisplayed()));
        textView11.check(matches(withText("331")));

        ViewInteraction textView12 = onView(
                allOf(withId(R.id.txtParadaName), withText("CORBAN"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                1),
                        isDisplayed()));
        textView12.check(matches(withText("CORBAN")));

        ViewInteraction textView13 = onView(
                allOf(withId(R.id.txtNumParada), withText("332"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        1),
                                0),
                        isDisplayed()));
        textView13.check(matches(withText("332")));

        ViewInteraction textView14 = onView(
                allOf(withId(R.id.txtParadaName), withText("CRUCE CON RUCANDIAL"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        1),
                                1),
                        isDisplayed()));
        textView14.check(matches(withText("CRUCE CON RUCANDIAL")));

        ViewInteraction textView15 = onView(
                allOf(withId(R.id.txtNumParada), withText("466"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        2),
                                0),
                        isDisplayed()));
        textView15.check(matches(withText("466")));

        ViewInteraction textView16 = onView(
                allOf(withId(R.id.txtParadaName), withText("BARRIO LA SIERRA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        2),
                                1),
                        isDisplayed()));
        textView16.check(matches(withText("BARRIO LA SIERRA")));

        ViewInteraction textView17 = onView(
                allOf(withId(R.id.txtNumParada), withText("467"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        3),
                                0),
                        isDisplayed()));
        textView17.check(matches(withText("467")));

        ViewInteraction textView18 = onView(
                allOf(withId(R.id.txtParadaName), withText("VICENTE TRUEBA 19"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        3),
                                1),
                        isDisplayed()));
        textView18.check(matches(withText("VICENTE TRUEBA 19")));

        ViewInteraction textView19 = onView(
                allOf(withId(R.id.txtNumParada), withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        4),
                                0),
                        isDisplayed()));
        textView19.check(matches(withText("1")));

        ViewInteraction textView20 = onView(
                allOf(withId(R.id.txtParadaName), withText("LOS CIRUELOS 47"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        4),
                                1),
                        isDisplayed()));
        textView20.check(matches(withText("LOS CIRUELOS 47")));

        pressBack();

        DataInteraction relativeLayout3 = onData(anything())
                .inAdapterView(allOf(withId(android.R.id.list),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(2);
        relativeLayout3.perform(click());

        ViewInteraction textView21 = onView(
                allOf(withId(R.id.txtNumParada), withText("355"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                0),
                        isDisplayed()));
        textView21.check(matches(withText("355")));

        ViewInteraction textView22 = onView(
                allOf(withId(R.id.txtParadaName), withText("OJAIZ"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                1),
                        isDisplayed()));
        textView22.check(matches(withText("OJAIZ")));

        ViewInteraction textView23 = onView(
                allOf(withId(R.id.txtNumParada), withText("352"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        1),
                                0),
                        isDisplayed()));
        textView23.check(matches(withText("352")));

        ViewInteraction textView24 = onView(
                allOf(withId(R.id.txtParadaName), withText("CAMARREAL 135"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        1),
                                1),
                        isDisplayed()));
        textView24.check(matches(withText("CAMARREAL 135")));

        ViewInteraction textView25 = onView(
                allOf(withId(R.id.txtNumParada), withText("56"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        2),
                                0),
                        isDisplayed()));
        textView25.check(matches(withText("56")));

        ViewInteraction textView26 = onView(
                allOf(withId(R.id.txtParadaName), withText("CAMARREAL 109"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        2),
                                1),
                        isDisplayed()));
        textView26.check(matches(withText("CAMARREAL 109")));

        ViewInteraction textView27 = onView(
                allOf(withId(R.id.txtNumParada), withText("57"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        3),
                                0),
                        isDisplayed()));
        textView27.check(matches(withText("57")));

        ViewInteraction textView28 = onView(
                allOf(withId(R.id.txtParadaName), withText("IGLESIA LA PEÑA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        3),
                                1),
                        isDisplayed()));
        textView28.check(matches(withText("IGLESIA LA PEÑA")));

        ViewInteraction textView29 = onView(
                allOf(withId(R.id.txtNumParada), withText("58"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        4),
                                0),
                        isDisplayed()));
        textView29.check(matches(withText("58")));

        ViewInteraction textView30 = onView(
                allOf(withId(R.id.txtParadaName), withText("PEÑACASTILLO ESCUELAS"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        4),
                                1),
                        isDisplayed()));
        textView30.check(matches(withText("PEÑACASTILLO ESCUELAS")));

        pressBack();

        DataInteraction relativeLayout4 = onData(anything())
                .inAdapterView(allOf(withId(android.R.id.list),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(3);
        relativeLayout4.perform(click());

        ViewInteraction textView31 = onView(
                allOf(withId(R.id.txtNumParada), withText("96"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                0),
                        isDisplayed()));
        textView31.check(matches(withText("96")));

        ViewInteraction textView32 = onView(
                allOf(withId(R.id.txtParadaName), withText("BARRIO PESQUERO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                1),
                        isDisplayed()));
        textView32.check(matches(withText("BARRIO PESQUERO")));

        ViewInteraction textView33 = onView(
                allOf(withId(R.id.txtNumParada), withText("97"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        1),
                                0),
                        isDisplayed()));
        textView33.check(matches(withText("97")));

        ViewInteraction textView34 = onView(
                allOf(withId(R.id.txtParadaName), withText("PARQUE VARADERO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        1),
                                1),
                        isDisplayed()));
        textView34.check(matches(withText("PARQUE VARADERO")));

        ViewInteraction textView35 = onView(
                allOf(withId(R.id.txtNumParada), withText("321"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        2),
                                0),
                        isDisplayed()));
        textView35.check(matches(withText("321")));

        ViewInteraction textView36 = onView(
                allOf(withId(R.id.txtParadaName), withText("MARQUES DE LA HERMIDA 15"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        2),
                                1),
                        isDisplayed()));
        textView36.check(matches(withText("MARQUES DE LA HERMIDA 15")));

        ViewInteraction textView37 = onView(
                allOf(withId(R.id.txtNumParada), withText("98"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        3),
                                0),
                        isDisplayed()));
        textView37.check(matches(withText("98")));

        ViewInteraction textView38 = onView(
                allOf(withId(R.id.txtParadaName), withText("MARQUES DE LA HERMIDA 1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        3),
                                1),
                        isDisplayed()));
        textView38.check(matches(withText("MARQUES DE LA HERMIDA 1")));

        ViewInteraction textView39 = onView(
                allOf(withId(R.id.txtNumParada), withText("273"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        4),
                                0),
                        isDisplayed()));
        textView39.check(matches(withText("273")));

        ViewInteraction textView40 = onView(
                allOf(withId(R.id.txtParadaName), withText("ESTACIONES"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        4),
                                1),
                        isDisplayed()));
        textView40.check(matches(withText("ESTACIONES")));

        pressBack();

        DataInteraction relativeLayout5 = onData(anything())
                .inAdapterView(allOf(withId(android.R.id.list),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(4);
        relativeLayout5.perform(click());

        ViewInteraction textView41 = onView(
                allOf(withId(R.id.txtNumParada), withText("45"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                0),
                        isDisplayed()));
        textView41.check(matches(withText("45")));

        ViewInteraction textView42 = onView(
                allOf(withId(R.id.txtParadaName), withText("AVENIDA DE VALDECILLA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        0),
                                1),
                        isDisplayed()));
        textView42.check(matches(withText("AVENIDA DE VALDECILLA")));

        ViewInteraction textView43 = onView(
                allOf(withId(R.id.txtNumParada), withText("9"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        1),
                                0),
                        isDisplayed()));
        textView43.check(matches(withText("9")));

        ViewInteraction textView44 = onView(
                allOf(withId(R.id.txtParadaName), withText("VALDECILLA"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        1),
                                1),
                        isDisplayed()));
        textView44.check(matches(withText("VALDECILLA")));

        ViewInteraction textView45 = onView(
                allOf(withId(R.id.txtNumParada), withText("268"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        2),
                                0),
                        isDisplayed()));
        textView45.check(matches(withText("268")));

        ViewInteraction textView46 = onView(
                allOf(withId(R.id.txtParadaName), withText("MERCADO MEJICO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        2),
                                1),
                        isDisplayed()));
        textView46.check(matches(withText("MERCADO MEJICO")));

        ViewInteraction textView47 = onView(
                allOf(withId(R.id.txtNumParada), withText("269"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        3),
                                0),
                        isDisplayed()));
        textView47.check(matches(withText("269")));

        ViewInteraction textView48 = onView(
                allOf(withId(R.id.txtParadaName), withText("CALLE ALTA 109"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        3),
                                1),
                        isDisplayed()));
        textView48.check(matches(withText("CALLE ALTA 109")));

        ViewInteraction textView49 = onView(
                allOf(withId(R.id.txtNumParada), withText("270"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        4),
                                0),
                        isDisplayed()));
        textView49.check(matches(withText("270")));

        ViewInteraction textView50 = onView(
                allOf(withId(R.id.txtParadaName), withText("CALLE ALTA 81"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.listaParadasLinea),
                                        4),
                                1),
                        isDisplayed()));
        textView50.check(matches(withText("CALLE ALTA 81")));

        pressBack();

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