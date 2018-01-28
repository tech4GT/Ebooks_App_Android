package com.codingblocks.codingblocks.models

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlin.collections.List

@Generated("net.hexar.json2pojo")
data class AuthorBooksCB(

        @SerializedName("limit")
        var limit: Long,
        @SerializedName("list")
        var list: List<com.codingblocks.codingblocks.models.List>,
        @SerializedName("page")
        var page: Long,
        @SerializedName("pages")
        var pages: Long,
        @SerializedName("total")
        var total: Long

)
