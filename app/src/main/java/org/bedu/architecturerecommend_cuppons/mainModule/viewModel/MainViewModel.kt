package org.bedu.architecturerecommend_cuppons.mainModule.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.bedu.architecturerecommend_cuppons.R
import org.bedu.architecturerecommend_cuppons.common.utils.getMessageErrorByCode
import org.bedu.architecturerecommend_cuppons.database.entities.CouponsEntity
import org.bedu.architecturerecommend_cuppons.mainModule.model.MainRepository

class MainViewModel: ViewModel() {

    private val repository = MainRepository()
    private val snackbarMsg = MutableLiveData<Int>()

    /*View Binding*/
    private val result = MutableLiveData<CouponsEntity>()

    fun getResult() = result
    fun getSnackbarMsg() = snackbarMsg

    fun getCouponByCode(code: String) {
        viewModelScope.launch {
            result.value = repository.consultCouponByCode(code)
        }
    }

    fun saveCoupon(couponsEntity: CouponsEntity) {
        viewModelScope.launch {
            try {
                repository.saveCoupon(couponsEntity)
                getCouponByCode(couponsEntity.code)
                snackbarMsg.value = R.string.created_coupon
            } catch (e: Exception) {
                snackbarMsg.value = e.message?.let { getMessageErrorByCode(it) }
            }

        }
    }


    /*Data Binding*/
    val coupon = MutableLiveData(CouponsEntity())
    private val hideKeyboard = MutableLiveData<Boolean>()
    val existCoupon = MutableLiveData<String>("Bienvenido")

    fun getHideKeyboard() = hideKeyboard

    fun getCouponByCodeDataBinding() {
        coupon.value?.code?.let { code ->
            viewModelScope.launch {
                hideKeyboard.value = true
                val couponConsulted = repository.consultCouponByCode(code) ?: CouponsEntity(code = code, isActive = false)
                coupon.value = couponConsulted
                Log.d("cou", couponConsulted.toString())
                existCoupon.value = if (couponConsulted.id.toInt() != 0) "Bienvenido" else "Nuevo"
                Log.d("cou2", existCoupon.value.toString())
            }
        }
    }

    fun saveCouponDataBinding() {
        hideKeyboard.value = true
        coupon.value?.let { couponsEntity ->
            viewModelScope.launch {
                try {

                    couponsEntity.isActive = true
                    repository.saveCoupon(couponsEntity)

                    getCouponByCodeDataBinding()

                    snackbarMsg.value = R.string.created_coupon
                } catch (e: Exception) {
                    snackbarMsg.value = e.message?.let { getMessageErrorByCode(it) }
                }

            }
        }

    }
}