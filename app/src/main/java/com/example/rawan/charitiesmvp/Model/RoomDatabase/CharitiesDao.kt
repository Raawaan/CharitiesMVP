package com.example.rawan.charitiesmvp.Model.RoomDatabase

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.rawan.charitiesmvp.Model.APICall.CharitiesData

/**
 * Created by rawan on 09/10/18.
 */
@Dao
interface CharitiesDao {
//    @Query("insert into Charities values (organization_name=:organization_name," +
//                                                "organization_type=:organization_type," +
//                                                "organization_desc=:organization_desc," +
//                                                "organization_pic=:organization_pic)")
//    fun INSERT(organization_name:String,organization_type:String,organization_desc:String,organization_pic:String)
        @Query("Select * from Charities ORDER BY id")
        fun loadAllUsers(): List<CharitiesEntity>
}