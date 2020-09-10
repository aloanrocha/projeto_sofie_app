package com.portfolio.sofieandroid.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataPost(
    @SerializedName("description")
    @Expose
    val description: String,
    @SerializedName("email")
    @Expose
    val email: String,
    @SerializedName("title")
    @Expose
    val title: String
)