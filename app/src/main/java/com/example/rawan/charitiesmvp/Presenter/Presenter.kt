package com.example.rawan.charitiesmvp.Presenter

import com.example.rawan.charitiesmvp.CharitiesDatabase
import com.example.rawan.charitiesmvp.Model.APICall.CharitiesData
import com.example.rawan.charitiesmvp.Model.Model
import com.example.rawan.charitiesmvp.View.ViewUI

/**
 * Created by rawan on 08/10/18.
 */
class Presenter(private var model: Model, var view:ViewUI):PresenterInterface{
    override fun executeAPI(){
        model.retrofitCall(onSuccess = {
            view.setData(it!!)
        },onError = {
            view.setError(it!!)
        })
    }

    override fun executeDatabase(charitiesDatabase: CharitiesDatabase) {
        model.databaseCall(charitiesDatabase,onSuccess = {
            view.setData(it!!)
        })
    }
}