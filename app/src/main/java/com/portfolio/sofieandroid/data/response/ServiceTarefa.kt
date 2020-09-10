package com.portfolio.sofieandroid.data.response

import com.portfolio.sofieandroid.data.model.Tarefas
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ServiceTarefa {
    @Headers("Accept: application/json")
    @GET("beta/task")
    fun listTarefas(): Call<Tarefas>
}