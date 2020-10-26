package com.nouman.gittreadingrepo

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.nouman.gittreadingrepo.R.id
import com.nouman.gittreadingrepo.ui.MainActivity
import org.junit.*
import org.junit.runner.*

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{
    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity>
            = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun whenActivityLaunched_ShimmerViewShouldBeVisible(){
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(id.shimmerLayout))
            .check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun whenActivityLaunched_internetIsConnected_recyclerViewShouldContainItems(){
        ActivityScenario.launch(MainActivity::class.java)
        Thread.sleep(5000)
        onView(withId(id.rvRepos)).check(RecyclerViewItemCountAssertion(30))
    }
    //Internet should be off
    @Test
    fun whenActivityLaunched_internetIsNotConnected_recyclerViewShouldNotContainItems(){
        ActivityScenario.launch(MainActivity::class.java)
        Thread.sleep(4000)
        onView(withId(id.rvRepos)).check(RecyclerViewAdapterExistAssertion(false));
    }
    //Internet should be off
    @Test
    fun whenActivityLaunched_internetIsNotConnected_ErrorViewShouldBeVisible(){
        ActivityScenario.launch(MainActivity::class.java)
        Thread.sleep(4000)
        onView(withId(id.rvRepos)).check(RecyclerViewAdapterExistAssertion(false));
        onView(withId(id.animationView)).check(matches(ViewMatchers.isDisplayed()))
    }
    //Internet should be off
    @Test
    fun whenActivityLaunched_onInternetReconnected_recyclerViewShouldContainItems(){
        ActivityScenario.launch(MainActivity::class.java)
        Thread.sleep(4000)
        onView(withId(id.rvRepos)).check(RecyclerViewAdapterExistAssertion(false));
        onView(withId(id.animationView)).check(matches(ViewMatchers.isDisplayed()))
        Thread.sleep(3000)
        //turn on the internet
        onView(withId(id.btnRetry)).perform(click())
        Thread.sleep(4000)
        onView(withId(id.rvRepos)).check(RecyclerViewItemCountAssertion(30))
    }

}