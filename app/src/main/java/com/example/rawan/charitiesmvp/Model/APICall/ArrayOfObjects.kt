package com.example.rawan.charitiesmvp.Model.APICall

import com.google.gson.annotations.SerializedName

/**
 * Created by rawan on 08/10/18.
 */

class ArrayOfObjects {
    @SerializedName("charities")
    var arrayOfCharites: List<CharitiesData>? = null
}