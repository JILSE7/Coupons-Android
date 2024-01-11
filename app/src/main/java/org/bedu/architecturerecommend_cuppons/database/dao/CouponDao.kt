package org.bedu.architecturerecommend_cuppons.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import org.bedu.architecturerecommend_cuppons.database.entities.CouponsEntity

@Dao
interface CouponDao {
    @Query("SELECT * FROM CouponEntity WHERE code = :code")
    suspend fun consultCouponByCode(code: String): CouponsEntity?

    @Insert
    suspend fun addCoupon(couponEntity: CouponsEntity): Long
}