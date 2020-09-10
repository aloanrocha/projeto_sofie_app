package com.portfolio.sofieandroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.support.v7.widget.Toolbar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tarefas.*


class ActivityListTarefas : AppCompatActivity() {

    var toolbar: Toolbar? = null
    var txtTarefas: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarefas)

        init_components()
        init_action()
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
