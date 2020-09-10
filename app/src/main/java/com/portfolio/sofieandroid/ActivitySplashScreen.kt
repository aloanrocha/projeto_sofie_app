package com.portfolio.sofieandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
import android.os.Handler
import android.support.v4.os.HandlerCompat.postDelayed


class ActivitySplashScreen : AppCompatActivity() {

    private val TIME_SPLASH_DISPLAY_LENGTH = 1950


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_splash)

        Handler().postDelayed({
            val mainIntent = Intent(this, ActivityListTarefas::class.java)
            this.startActivity(mainIntent)
            this.finish()
        }, TIME_SPLASH_DISPLAY_LENGTH.toLong())
    }
}
