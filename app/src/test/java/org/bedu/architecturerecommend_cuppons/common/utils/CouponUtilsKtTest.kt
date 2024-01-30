package org.bedu.architecturerecommend_cuppons.common.utils

import org.bedu.architecturerecommend_cuppons.R
import org.bedu.architecturerecommend_cuppons.database.entities.CouponsEntity
import org.junit.Assert.*
import org.junit.Test

class CouponUtilsKtTest {

    @Test
    fun validateTextCodeSuccessTest(){
        val code = "WELCOME"

        assertTrue(validateTextCode(code))
    }

    @Test
    fun validateTextCodeEmptyTest(){
        val code = ""

        assertFalse(validateTextCode(code))
    }


    @Test
    fun validateMinLengthTest(){
        val code = "12345"
        val code2 = "1234"

        assertTrue(validateTextCode(code))
        assertFalse(validateTextCode(code2))
    }

    @Test
    fun validateMaxLengthTest(){
        val code = "1234567890"
        val code2 = "12345678901"

        assertTrue(validateTextCode(code))
        assertFalse(validateTextCode(code2))
    }

    @Test
    fun getMsgErrorByCodeNullTest(){
        val errorCode = null
        val expectedValue = R.string.error_no_contemplado

        val result = getMessageErrorByCode(errorCode)
        assertEquals(expectedValue, result)
    }

    @Test
    fun getMsgErrorByCodeExistTest(){
        val errorCode = Constants.ERROR_EXIST
        val expectedValue = R.string.error_exist_string

        val result = getMessageErrorByCode(errorCode)
        assertEquals("Error al evaluar un cúpon existente",expectedValue, result)
    }


    @Test
    fun getMsgErrorByCodeLengthTest(){
        val errorCode = Constants.ERROR_LENGTH
        val expectedValue = R.string.error_length_string

        val result = getMessageErrorByCode(errorCode)
        assertEquals("Error al evaluar longitud un cúpon existente",expectedValue, result)
    }


    @Test
    fun checkNotNullCoupon() {
        val coupon = CouponsEntity(code ="ANDROID", description = "Cursos", isActive = true)

        assertNotNull(coupon)
    }

    @Test
    fun checkGroupSuccessTest() {
        val coupons = arrayOf("said", "android", "test")
        val coupons2 = arrayOf("said", "android", "test")

        assertEquals(coupons.size, 3)

        assertArrayEquals(coupons, coupons2)
    }
}