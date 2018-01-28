package com.codingblocks.codingblocks.models

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("net.hexar.json2pojo")
data class Counts (

    @SerializedName("changeRequests")
    var changeRequests: Long,
    @SerializedName("discussions")
    var discussions: Long,
    @SerializedName("stars")
    var stars: Long,
    @SerializedName("subscriptions")
    var subscriptions: Long,
    @SerializedName("updates")
    var updates: Long

)
