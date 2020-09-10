package com.portfolio.sofieandroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ActivityAddTarefas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_tarefas)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val mainIntent = Intent(this, ActivityListTarefas::class.java)
        this.startActivity(mainIntent)
        this.finish()
    }

}
