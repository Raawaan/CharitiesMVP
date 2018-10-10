package com.example.rawan.charitiesmvp.Model.APICall

import com.example.rawan.charitiesmvp.CharitiesDatabase
import com.example.rawan.charitiesmvp.Model.RoomDatabase.CharitiesEntity
import com.example.rawan.charitiesmvp.CharitiesDataAsyncTask
import retrofit2.Call
import retrofit2.Callback

/**
 * Created by rawan on 08/10/18.
 */

class CharitiesRemoteModel(private val retrofitCall: RetrofitCall) {
fun getCharitiesDataFromAPI(onSuccess: (list: List<CharitiesData>?) -> Unit, onError: (t: Throwable?) -> Unit) {
        val call: Call<ArrayOfObjects> = retrofitCall.getData()
        call.enqueue(object : Callback<ArrayOfObjects> {
            override fun onResponse(call: Call<ArrayOfObjects>, response: retrofit2.Response<ArrayOfObjects>?) {
                onSuccess(response?.body()?.arrayOfCharites)
            }
            override fun onFailure(call: Call<ArrayOfObjects>?, t: Throwable?) {
                onError(t)
            }
        })
    }
}