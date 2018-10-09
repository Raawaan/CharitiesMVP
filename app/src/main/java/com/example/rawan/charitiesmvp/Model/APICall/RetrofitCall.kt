package com.example.rawan.charitiesmvp.Model.APICall

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


/**
 * Created by rawan on 08/10/18.
 */
interface RetrofitCall{
    @GET("7arka_get_charities")
    fun getData(): Call<ArrayOfObjects>

    companion object {
        val baseLink:String ="http://demo8044805.mockable.io/"
        fun createBuilder(): RetrofitCall {
            val retrofit = Retrofit.Builder()
                    .baseUrl(baseLink)
                    .addConverterFactory(GsonConverterFactory.create()).build()
            return retrofit.create(RetrofitCall::class.java)
        }
    }
}