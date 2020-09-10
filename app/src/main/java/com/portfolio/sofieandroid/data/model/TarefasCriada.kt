package com.portfolio.sofieandroid.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class TarefasCriada {
    @SerializedName("success")
    @Expose
    private val success: Boolean = false
    @SerializedName("data")
    @Expose
    private val data: Data? = null
}