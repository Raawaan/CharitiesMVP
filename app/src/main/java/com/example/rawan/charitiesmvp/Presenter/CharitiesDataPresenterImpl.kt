package com.example.rawan.charitiesmvp.Presenter

import com.example.rawan.charitiesmvp.CharitiesDatabase
import com.example.rawan.charitiesmvp.Model.CharitiesDataModel
import com.example.rawan.charitiesmvp.View.CharitiesViewUI

/**
 * Created by rawan on 08/10/18.
 */
class CharitiesDataPresenterImpl(private var charitiesDataModel: CharitiesDataModel, var charitiesView:CharitiesViewUI):CharitiesDataPresenter{
    override fun executeAPI(){
        charitiesDataModel.getCharitiesDataFromAPI(onSuccess = {
            charitiesView.setData(it!!)
        },onError = {
            charitiesView.setError(it!!)
        })
    }

    override fun executeDatabase(charitiesDatabase: CharitiesDatabase) {
        charitiesDataModel.getCharitiesDataFromDatabase(charitiesDatabase,onSuccess = {
            charitiesView.setData(it!!)
        })
    }
}