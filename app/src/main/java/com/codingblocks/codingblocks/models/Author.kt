package com.codingblocks.codingblocks.models

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

data class Author(
        @SerializedName("counts")
        var counts: Counts,
        @SerializedName("dates")
        var dates: Dates,
        @SerializedName("github")
        var github: Github,
        @SerializedName("id")
        var id: String,
        @SerializedName("name")
        var name: String,
        @SerializedName("permissions")
        var permissions: Permissions,
        @SerializedName("type")
        var type: String,
        @SerializedName("urls")
        var urls: Urls,
        @SerializedName("username")
        var username: String,
        @SerializedName("website")
        var website: String? = null
)
