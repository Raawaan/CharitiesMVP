package com.example.rawan.charitiesmvp.View

import com.example.rawan.charitiesmvp.CharitiesDatabase
import com.example.rawan.charitiesmvp.Model.APICall.CharitiesData

/**
 * Created by rawan on 08/10/18.
 */
interface ViewUI{
    fun makeRetrofitAPICall()
    fun makeDatabaseCall()
    fun setData(list: List<CharitiesData>)
    fun setError(t: Throwable)
}