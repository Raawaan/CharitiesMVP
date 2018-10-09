package com.example.rawan.charitiesmvp.Model.RoomDatabase

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by rawan on 09/10/18.
 */
@Entity(tableName="Charities")
data class CharitiesEntity(
        @PrimaryKey(autoGenerate = true)var id:Int,
        val organization_name:String,
        val organization_type:String,
        val organization_desc:String,
        val organization_pic:String){
    @Ignore
    constructor(organization_name: String,organization_type: String,organization_desc: String,organization_pic: String): this(0,organization_name,organization_type,organization_desc,organization_pic)
}