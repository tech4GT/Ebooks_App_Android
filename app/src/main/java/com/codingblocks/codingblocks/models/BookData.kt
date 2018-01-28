package com.codingblocks.codingblocks.models

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlin.collections.List

@Generated("net.hexar.json2pojo")
data class BookData(

        @SerializedName("progress")
        var progress: Progress,
        @SerializedName("sections")
        var sections: List<Section>,
        @SerializedName("version")
        var version: String

)
