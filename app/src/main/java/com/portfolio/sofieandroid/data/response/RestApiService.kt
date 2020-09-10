package com.portfolio.sofieandroid.data.response

import android.provider.Settings.System.getString
import android.util.Log
import com.portfolio.sofieandroid.R
import com.portfolio.sofieandroid.data.model.DataPost
import com.portfolio.sofieandroid.data.model.TarefasCriada
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiService {

    fun addTarefa(dataPost: DataPost, onResult: (TarefasCriada) -> Unit) {
        val callApi = RetrofitInit().getTarefa().addTarefa(dataPost)
        callApi.enqueue(
            object : Callback<TarefasCriada> {
                override fun onFailure(call: Call<TarefasCriada>, t: Throwable) {
                    Log.e("onFailure error", t?.message)

                }

                override fun onResponse(call: Call<TarefasCriada>, response: Response<TarefasCriada>) {
                    val addTarefa = response.body()
                    addTarefa?.let { onResult(it) }
                }
            }
        )
    }

}