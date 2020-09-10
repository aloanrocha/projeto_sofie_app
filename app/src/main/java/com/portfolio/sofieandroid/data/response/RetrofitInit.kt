package com.portfolio.sofieandroid.data.response

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInit {

    private val URL_Sofie = "https://9g1borgfz0.execute-api.sa-east-1.amazonaws.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(URL_Sofie)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getTarefa() = retrofit.create(ServiceTarefa::class.java)
}