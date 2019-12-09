package com.android.tugasbesarkotlin_orderfoodapp


import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.view.animation.AnimationUtils
import android.widget.ImageView

import android.widget.TextView
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    lateinit var animationDrawable: AnimationDrawable



    internal lateinit var txt_welcome: TextView
    internal lateinit var imgview: ImageView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        animationDrawable = layeranimation_splash.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(3000)
        animationDrawable.setExitFadeDuration(3000)
        animationDrawable.start()


        txt_welcome = findViewById(R.id.splashtext_welcome)
        imgview = findViewById(R.id.logo)

        val myanim = AnimationUtils.loadAnimation(this, R.anim.my_transasition)

        txt_welcome.startAnimation(myanim)
        imgview.startAnimation(myanim)

        val intent = Intent(this, SignIn::class.java)

        val splashtext = AnimationUtils.loadAnimation(this,R.anim.bounce)
        splashtext_welcome.startAnimation(splashtext)

        val logosplash = AnimationUtils.loadAnimation(this, R.anim.blink)
        logo.startAnimation(logosplash)

        val timer = object : Thread() {

            override fun run() {
                try {
                    Thread.sleep(7000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    startActivity(intent)

                }
            }
        }
        timer.start()
    }

}
