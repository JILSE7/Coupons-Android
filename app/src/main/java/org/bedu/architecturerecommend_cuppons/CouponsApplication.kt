package org.bedu.architecturerecommend_cuppons

import android.app.Application
import androidx.room.Room
import org.bedu.architecturerecommend_cuppons.database.CouponDatabase

class CouponsApplication : Application(){
    companion object {
        lateinit var database: CouponDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this, CouponDatabase::class.java, "CouponDatabase").build()
    }
}