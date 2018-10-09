package com.example.rawan.charitiesmvp.Model.APICall

import com.google.gson.annotations.SerializedName

/**
 * Created by rawan on 08/10/18.
 */
data class CharitiesData(
    @SerializedName("organization_name")
    val organization_name:String,
    @SerializedName("organization_type")
    val  organization_type:String,
    @SerializedName("organization_pic")
    val organization_pic:String,
    @SerializedName("organization_desc")
    val  organization_desc:String)