package com.portfolio.sofieandroid.presentation.list

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.portfolio.sofieandroid.R
import com.portfolio.sofieandroid.data.model.DataPost
import com.portfolio.sofieandroid.data.response.RestApiService
import kotlinx.android.synthetic.main.activity_add_tarefas.*

class ActivityAddTarefas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_tarefas)

        init_action()
    }

    private fun init_action() {

     btn_cancelar.setOnClickListener { onBackPressed() }
     btn_salvar.setOnClickListener { fun_salvar_dados() }

    }

    private fun fun_salvar_dados() {

        val apiService = RestApiService()
        val dataPost = DataPost(
            title = edit_email_nova_tarefa.text.toString(),
            email = edit_nome_nova_tarefa.text.toString(),
            description= edit_descricao_nova_tarefa.text.toString()
        )

        apiService.addTarefa(dataPost){
        }
        onBackPressed()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val mainIntent = Intent(this, ActivityListTarefas::class.java)
        this.startActivity(mainIntent)
        this.finish()
    }

}
