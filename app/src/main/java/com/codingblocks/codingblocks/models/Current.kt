package com.codingblocks.codingblocks.models

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("net.hexar.json2pojo")
data class Current (

    @SerializedName("done")
    var done: Boolean,
    @SerializedName("index")
    var index: Long,
    @SerializedName("introduction")
    var introduction: Boolean,
    @SerializedName("level")
    var level: String,
    @SerializedName("next")
    var next: Next,
    @SerializedName("path")
    var path: String,
    @SerializedName("percent")
    var percent: Long,
    @SerializedName("title")
    var title: String

)
