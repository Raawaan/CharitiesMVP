package com.example.rawan.charitiesmvp.Model.RoomDatabase

import com.example.rawan.charitiesmvp.CharitiesDataAsyncTask
import com.example.rawan.charitiesmvp.CharitiesDatabase
import com.example.rawan.charitiesmvp.Model.APICall.CharitiesData

/**
 * Created by rawan on 10/10/18.
 */
class CharitiesLocalModel{
fun getCharitiesDataFromDatabase(charitiesDatabase: CharitiesDatabase, onSuccess: (list: List<CharitiesData>?) -> Unit) {
        val objectToMap: MutableList<CharitiesData>? = mutableListOf()
        CharitiesDataAsyncTask(inBackground = {
            val listOfCharitiesEntity: List<CharitiesEntity> = charitiesDatabase.CharitiesDao().loadAllUsers()
            for (item in listOfCharitiesEntity) {
                val charitiesEntity = CharitiesData(item.organization_name,
                        item.organization_type, item.organization_pic, item.organization_desc)
                objectToMap?.add(charitiesEntity)
            }
            return@CharitiesDataAsyncTask objectToMap!!
        }, onSuccessBackground = {
            onSuccess(objectToMap?.toList())
        }).execute()
    }
}