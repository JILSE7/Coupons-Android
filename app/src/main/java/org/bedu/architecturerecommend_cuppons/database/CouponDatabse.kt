package org.bedu.architecturerecommend_cuppons.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.bedu.architecturerecommend_cuppons.database.dao.CouponDao
import org.bedu.architecturerecommend_cuppons.database.entities.CouponsEntity

@Database(entities = [CouponsEntity::class], version = 1)
abstract class CouponDatabase: RoomDatabase() {
    abstract fun couponDao(): CouponDao

}