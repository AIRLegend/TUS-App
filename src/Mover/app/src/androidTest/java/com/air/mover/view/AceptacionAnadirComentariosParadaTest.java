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
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AceptacionAnadirComentariosParadaTest {

    @Rule
    public ActivityTestRule<SplashScreen> mActivityTestRule = new ActivityTestRule<>(SplashScreen.class);

    @Test
    public void aceptacionAnadirComentariosParada() {
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
                .atPosition(5);
        relativeLayout.perform(click());

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.listaParadasLinea),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                2)));
        recyclerView.perform(actionOnItemAtPosition(5, click()));

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editText),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v4.widget.NestedScrollView")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("Parada más cercana al hotel"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.button_save_comment), withText("Guardar nota"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v4.widget.NestedScrollView")),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton.perform(click());

        pressBack();


        ViewInteraction recyclerView1 = onView(
                allOf(withId(R.id.listaParadasLinea),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                2)));
        recyclerView1.perform(actionOnItemAtPosition(5, click()));



        ViewInteraction appCompatEditTex1 = onView(
                allOf(withId(R.id.editText), withText("Parada más cercana al hotel"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v4.widget.NestedScrollView")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditTex1.check(matches(withText("Parada más cercana al hotel")));


        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editText), withText("Parada más cercana al hotel"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v4.widget.NestedScrollView")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("- Parada más cercana al hotel.                         - Está bien comunicada."));


        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.button_save_comment), withText("Guardar nota"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v4.widget.NestedScrollView")),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton2.perform(click());

        pressBack();


        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.listaParadasLinea),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                2)));
        recyclerView2.perform(actionOnItemAtPosition(5, click()));



        ViewInteraction appCompatEditTex2 = onView(
                allOf(withId(R.id.editText), withText("- Parada más cercana al hotel.                         - Está bien comunicada."),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v4.widget.NestedScrollView")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditTex2.check(matches(withText("- Parada más cercana al hotel.                         - Está bien comunicada.")));


        pressBack();


        ViewInteraction recyclerView3 = onView(
                allOf(withId(R.id.listaParadasLinea),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                2)));
        recyclerView3.perform(actionOnItemAtPosition(7, click()));

        ViewInteraction appCompatEditText1 = onView(
                allOf(withId(R.id.editText),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v4.widget.NestedScrollView")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText1.perform(replaceText("Bajarse en esta parada"), closeSoftKeyboard());

        ViewInteraction appCompatButton1 = onView(
                allOf(withId(R.id.button_save_comment), withText("Guardar nota"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v4.widget.NestedScrollView")),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton1.perform(click());

        pressBack();



        ViewInteraction recyclerView4 = onView(
                allOf(withId(R.id.listaParadasLinea),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                2)));
        recyclerView4.perform(actionOnItemAtPosition(7, click()));



        ViewInteraction appCompatEditTex3 = onView(
                allOf(withId(R.id.editText), withText("Bajarse en esta parada"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v4.widget.NestedScrollView")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditTex3.check(matches(withText("Bajarse en esta parada")));


        pressBack();

        pressBack();




        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.navigation), isDisplayed()));
        bottomNavigationItemView.perform(click());


        ViewInteraction recyclerView5 = onView(
                allOf(withId(R.id.lista_paradas),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)));
        recyclerView5.perform(actionOnItemAtPosition(5, click()));


        ViewInteraction appCompatEditTex4 = onView(
                allOf(withId(R.id.editText), withText("- Parada más cercana al hotel.                         - Está bien comunicada."),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v4.widget.NestedScrollView")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditTex4.check(matches(withText("- Parada más cercana al hotel.                         - Está bien comunicada.")));



        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.editText), withText("- Parada más cercana al hotel.                         - Está bien comunicada."),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v4.widget.NestedScrollView")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText(""));

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.button_save_comment), withText("Guardar nota"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v4.widget.NestedScrollView")),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton4.perform(click());

        pressBack();



        ViewInteraction recyclerView6 = onView(
                allOf(withId(R.id.lista_paradas),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)));
        recyclerView6.perform(actionOnItemAtPosition(5, click()));


        ViewInteraction appCompatEditTex5 = onView(
                allOf(withId(R.id.editText), withText(""),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v4.widget.NestedScrollView")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditTex5.check(matches(withText("")));

        pressBack();

        ViewInteraction recyclerView7 = onView(
                allOf(withId(R.id.lista_paradas),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)));
        recyclerView7.perform(actionOnItemAtPosition(7, click()));


        ViewInteraction appCompatEditTex6 = onView(
                allOf(withId(R.id.editText), withText("Bajarse en esta parada"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v4.widget.NestedScrollView")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditTex6.check(matches(withText("Bajarse en esta parada")));


        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.editText), withText("Bajarse en esta parada"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v4.widget.NestedScrollView")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText7.perform(replaceText(""));


        ViewInteraction appCompatButton3= onView(
                allOf(withId(R.id.button_save_comment), withText("Guardar nota"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v4.widget.NestedScrollView")),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton3.perform(click());

        pressBack();


        ViewInteraction recyclerView8 = onView(
                allOf(withId(R.id.lista_paradas),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)));
        recyclerView8.perform(actionOnItemAtPosition(7, click()));


        ViewInteraction appCompatEditTex7 = onView(
                allOf(withId(R.id.editText), withText(""),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v4.widget.NestedScrollView")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditTex7.check(matches(withText("")));

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
