package com.example.rawan.charitiesmvp

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.rawan.charitiesmvp.Model.APICall.CharitiesData
import com.example.rawan.charitiesmvp.Model.RoomDatabase.CharitiesDao
import com.example.rawan.charitiesmvp.Model.RoomDatabase.CharitiesEntity

/**
 * Created by rawan on 09/10/18.
 */
@Database(entities = [(CharitiesEntity::class)], version =1, exportSchema = false)
abstract class CharitiesDatabase : RoomDatabase() {
    abstract fun CharitiesDao(): CharitiesDao

    companion object {
        var DATABASE_NAME = "JFTDatabase"
        private var INSTANCE: CharitiesDatabase? = null
        @Synchronized
        fun getInstance(context: Context): CharitiesDatabase {
            if (INSTANCE == null)
            {
                INSTANCE = Room
                        .databaseBuilder(context.applicationContext,
                                CharitiesDatabase::class.java, DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return INSTANCE!!
        }

    }
}