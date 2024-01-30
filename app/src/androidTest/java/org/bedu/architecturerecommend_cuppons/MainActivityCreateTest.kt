package org.bedu.architecturerecommend_cuppons


import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.bedu.architecturerecommend_cuppons.mainModule.view.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.Matchers.not

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityCreateTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun createCouponTest(){
         val etCoupon = Espresso.onView(withId(R.id.etCoupon))

        etCoupon.check(ViewAssertions.matches(withText(""))) // verifica que view coincida con el texto
        etCoupon.perform(click())
        etCoupon.perform(replaceText("WELCOME_02"))

        val btnConsult = Espresso.onView(withId(R.id.btnConsult))
        btnConsult.perform(click())

        val btnCreate = Espresso.onView(withId(R.id.btnCreate))
        btnCreate.check(ViewAssertions.matches(isDisplayed()))

        val etDescription = Espresso.onView(withId(R.id.etDescription))
        etDescription.perform(click())
        etDescription.perform(replaceText("2X1 SODAS"))

        /*etCoupon.perform(replaceText("WELCOME_01"))
        btnCreate.check(ViewAssertions.matches(isDisplayed()))*/

        /*val snackbar = Espresso.onView(withId(com.google.android.material.R.id.snackbar_text))
        snackbar.check(ViewAssertions.matches(withText("Cupón creado")))*/
    }


    /*
    * Corrobora que el botón "crear" no existe y no es visible
    * Test: Nuestro etCoupon inicia vacía, luego haz click sobre el, añade el texto "WELCOME_01"
    * y ahora desde btnConsult, haz click sobre el
    * */

    @Test
    fun consultCouponExistTest(){
         val etCoupon = Espresso.onView(withId(R.id.etCoupon))
        etCoupon.check(ViewAssertions.matches(withText("")))
        etCoupon.perform(click())
        etCoupon.perform(replaceText("WELCOME_01"))

        val btnConsult = Espresso.onView(withId(R.id.btnConsult))
        btnConsult.perform(click())

        val btnCreate = Espresso.onView(withId(R.id.btnCreate))
        btnCreate.check(ViewAssertions.matches(not(isDisplayed())))


    }
}