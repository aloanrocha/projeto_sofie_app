package com.portfolio.sofieandroid.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Tarefas {
    @SerializedName("data")
    @Expose
    val tarefas: List<Data>? = null
}