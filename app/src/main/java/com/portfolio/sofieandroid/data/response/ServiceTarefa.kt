package com.portfolio.sofieandroid.data.response

import com.portfolio.sofieandroid.data.model.DataPost
import com.portfolio.sofieandroid.data.model.Tarefas
import com.portfolio.sofieandroid.data.model.TarefasCriada
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ServiceTarefa {
    @Headers("Accept: application/json")
    @GET("beta/task")
    fun listTarefas(): Call<Tarefas>

    @Headers("Accept: application/json")
    @POST("beta/task")
    fun addTarefa(@Body addTarefas: DataPost): Call<TarefasCriada>
}