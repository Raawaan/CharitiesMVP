package com.example.rawan.charitiesmvp.Presenter

import com.example.rawan.charitiesmvp.CharitiesDatabase
import com.example.rawan.charitiesmvp.Model.APICall.CharitiesRemoteModel
import com.example.rawan.charitiesmvp.Model.RoomDatabase.CharitiesLocalModel
import com.example.rawan.charitiesmvp.View.CharitiesViewUI

/**
 * Created by rawan on 08/10/18.
 */
class CharitiesDataPresenterImpl(private var charitiesRemoteModel: CharitiesRemoteModel,private var charitiesLocalModel: CharitiesLocalModel, var charitiesView:CharitiesViewUI):CharitiesDataPresenter{
    override fun executeAPI(){
        charitiesRemoteModel.getCharitiesDataFromAPI(onSuccess = {
            charitiesView.setData(it!!)
        },onError = {
            charitiesView.setError(it!!)
        })
    }

    override fun executeDatabase(charitiesDatabase: CharitiesDatabase) {
        charitiesLocalModel.getCharitiesDataFromDatabase(charitiesDatabase,onSuccess = {
            charitiesView.setData(it!!)
        })
    }
}