package org.bedu.architecturerecommend_cuppons.mainModule.model

import org.bedu.architecturerecommend_cuppons.common.utils.Constants
import org.bedu.architecturerecommend_cuppons.common.utils.validateTextCode
import org.bedu.architecturerecommend_cuppons.database.entities.CouponsEntity

class MainRepository {

    private val roomDatabase = RoomDatabase()


    suspend fun consultCouponByCode(code: String) = roomDatabase.consultCouponByCode(code)

    suspend fun saveCoupon(couponsEntity: CouponsEntity) {
        if (!validateTextCode(couponsEntity.code)) throw Exception(Constants.ERROR_LENGTH)

        roomDatabase.saveCoupon(couponsEntity)

    }
}