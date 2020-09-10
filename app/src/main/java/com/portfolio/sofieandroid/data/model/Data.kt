package com.portfolio.sofieandroid.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("_id")
    @Expose
     val id: String,
    @SerializedName("description")
    @Expose
     val description: String,
    @SerializedName("email")
    @Expose
     val email: String,
    @SerializedName("when")
    @Expose
     val time: String,
    @SerializedName("title")
    @Expose
     val title: String
)