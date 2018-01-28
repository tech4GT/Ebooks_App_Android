package com.codingblocks.codingblocks.models

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("net.hexar.json2pojo")
data class Download (

    @SerializedName("epub")
    var epub: String,
    @SerializedName("mobi")
    var mobi: String,
    @SerializedName("pdf")
    var pdf: String

)
