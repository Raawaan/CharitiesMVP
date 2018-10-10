package com.example.rawan.charitiesmvp.Presenter

import com.example.rawan.charitiesmvp.CharitiesDatabase

/**
 * Created by rawan on 08/10/18.
 */
interface CharitiesDataPresenter {
    fun executeAPI()
    fun executeDatabase(charitiesDatabase: CharitiesDatabase)
}