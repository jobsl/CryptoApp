package com.point56.android.cryptoapp.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinInfoListOfData (

    @SerializedName("Data")
    @Expose
    val data: List<Datum>? = null


)