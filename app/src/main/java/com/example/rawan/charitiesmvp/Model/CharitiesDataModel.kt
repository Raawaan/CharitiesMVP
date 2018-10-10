package com.example.rawan.charitiesmvp.Model

import com.example.rawan.charitiesmvp.CharitiesDatabase
import com.example.rawan.charitiesmvp.Model.APICall.ArrayOfObjects
import com.example.rawan.charitiesmvp.Model.APICall.CharitiesData
import com.example.rawan.charitiesmvp.Model.APICall.RetrofitCall
import com.example.rawan.charitiesmvp.Model.RoomDatabase.CharitiesEntity
import com.example.rawan.charitiesmvp.CharitiesDataAsyncTask
import retrofit2.Call
import retrofit2.Callback

/**
 * Created by rawan on 08/10/18.
 */
class CharitiesDataModel {

    private val api = RetrofitCall.createBuilder()
    fun getCharitiesDataFromAPI(onSuccess: (list: List<CharitiesData>?) -> Unit, onError: (t: Throwable?) -> Unit) {
        val call: Call<ArrayOfObjects> = api.getData()
        call.enqueue(object : Callback<ArrayOfObjects> {
            override fun onResponse(call: Call<ArrayOfObjects>, response: retrofit2.Response<ArrayOfObjects>?) {
                onSuccess(response?.body()?.arrayOfCharites)
            }
            override fun onFailure(call: Call<ArrayOfObjects>?, t: Throwable?) {
                onError(t)
            }
        })
    }

    fun getCharitiesDataFromDatabase(charitiesDatabase: CharitiesDatabase, onSuccess: (list: List<CharitiesData>?) -> Unit) {
        var objectToMap: MutableList<CharitiesData>? = mutableListOf()
        CharitiesDataAsyncTask(inBackground = {
            val listOfCharitiesEntity: List<CharitiesEntity> = charitiesDatabase.CharitiesDao().loadAllUsers()
            for (item in listOfCharitiesEntity) {
                val charitiesEntity = CharitiesData(item.organization_name, item.organization_type, item.organization_pic, item.organization_desc)
                objectToMap?.add(charitiesEntity)
            }
            return@CharitiesDataAsyncTask objectToMap!!
        }, onSuccessBackground = {
            onSuccess(objectToMap!!.toList())
        }).execute()


    }
}