package org.bedu.architecturerecommend_cuppons.mainModule.model

import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.bedu.architecturerecommend_cuppons.CouponsApplication
import org.bedu.architecturerecommend_cuppons.common.utils.Constants
import org.bedu.architecturerecommend_cuppons.database.dao.CouponDao
import org.bedu.architecturerecommend_cuppons.database.entities.CouponsEntity

class RoomDatabase {
    private val dao: CouponDao by lazy {  CouponsApplication.database.couponDao() }

    suspend fun consultCouponByCode(code: String) = dao.consultCouponByCode(code)

    suspend fun saveCoupon(couponsEntity: CouponsEntity) = withContext(Dispatchers.IO) {
        try {
            dao.addCoupon(couponsEntity)
        } catch (e: Exception) {
            (e as? SQLiteConstraintException)?.let {
                throw Exception(Constants.ERROR_EXIST)
            }

            throw Exception(e.message ?: Constants.ERROR_UNKNOW)
        }
    }
}