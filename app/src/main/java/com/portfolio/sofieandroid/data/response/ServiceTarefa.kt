package com.portfolio.sofieandroid.data.response

import com.portfolio.sofieandroid.data.model.Tarefas
import retrofit2.Call
import retrofit2.http.GET

interface ServiceTarefa {
    @GET("beta/task")
    fun listTarefas(): Call<List<Tarefas>>

}