package com.portfolio.sofieandroid.presentation.list

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.widget.TextView
import android.widget.Toast
import com.portfolio.sofieandroid.R
import com.portfolio.sofieandroid.data.model.Tarefas
import com.portfolio.sofieandroid.data.response.RetrofitInit
import kotlinx.android.synthetic.main.activity_tarefas.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ActivityListTarefas : AppCompatActivity() {

    var toolbar: Toolbar? = null
    var txtTarefas: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarefas)

        init_components()
        init_action()
        getTarefasApi()
    }

    private fun init_recycler(tarefas: List<Tarefas>) {
        with(recyclerTarefas) {
            layoutManager = LinearLayoutManager(this@ActivityListTarefas, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
            adapter = ListTarefasAdapter(tarefas)
        }
    }


    fun getTarefasApi() {
        val call = RetrofitInit().getTarefa().listTarefas()
        call.enqueue(object : Callback<List<Tarefas>?> {
            override fun onResponse(
                call: Call<List<Tarefas>?>?,
                response: Response<List<Tarefas>?>?
            ) {
                response?.body()?.let {
                    val tarefas: List<Tarefas> = it
                    init_recycler(tarefas)
                }
            }

            override fun onFailure(
                call: Call<List<Tarefas>?>?,
                t: Throwable?
            ) {
            }
        })

    }

    //Caso seja necessario testa com dados mokado
    fun getTarefas(): List<Tarefas> {
        return listOf(
            Tarefas("1010", "Concluir as tasks do dia", "aloanteste_@gmail.com", "as 11 horas", "Tarefa do Dia")
            , Tarefas("1011", "Concluir as tasks do dia", "aloanteste_1@gmail.com", "as 11 horas", "Tarefa do Dia")
            , Tarefas("1012", "Concluir as tasks do dia", "aloanteste_2@gmail.com", "as 11 horas", "Tarefa do Dia")
            , Tarefas("1013", "Concluir as tasks do dia", "aloanteste_3@gmail.com", "as 11 horas", "Tarefa do Dia")
        )
    }

    private fun init_components() {
        toolbar?.findViewById<Toolbar>(R.id.toolBarTitleList)
        txtTarefas?.findViewById<TextView>(R.id.txt_title)

        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar?.title = getString(R.string.app_title)
        }
    }


    private fun init_action() {
        btn_add_nova_tarefa.setOnClickListener {
            val mainIntent = Intent(this, ActivityAddTarefas::class.java)
            this.startActivity(mainIntent)
            this.finish()
        }
    }

    override fun onBackPressed() {
        fun_alert_exit()
    }

    private fun fun_alert_exit() {
        val dialogClickListener = DialogInterface.OnClickListener { _, which ->
            when (which) {
                DialogInterface.BUTTON_POSITIVE -> {
                    super.onBackPressed()
                    this.finish()
                }

                DialogInterface.BUTTON_NEGATIVE -> {
                    Toast.makeText(this, ":D", Toast.LENGTH_SHORT).show()
                }
            }//Yes button clicked
            //No button clicked
        }

        val builder = AlertDialog.Builder(this)
        builder.setMessage(getString(R.string.app_msg_para_sair))
            .setPositiveButton(getString(R.string.app_msg_para_sair_nao), dialogClickListener)
            .setNegativeButton(getString(R.string.app_msg_para_sair_sim), dialogClickListener).show()
    }
}
