package com.android.tugasbesarkotlin_orderfoodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.android.tugasbesarkotlin_orderfoodapp.Paging.ProductListActivity
import kotlinx.android.synthetic.main.activity_dashboard.*

class Dashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val kanan =  AnimationUtils.loadAnimation(this, R.anim.slide_in_right)
        kanan1.startAnimation(kanan)
        kanan2.startAnimation(kanan)

        val naik = AnimationUtils.loadAnimation(this, R.anim.naik)
        kanan3.startAnimation(naik)

        val kiri =  AnimationUtils.loadAnimation(this, R.anim.kiri)
        kiri2.startAnimation(kiri)
        kiri3.startAnimation(kiri)


        val turun = AnimationUtils.loadAnimation(this, R.anim.turun)
        kiri1.startAnimation(turun)

        kanan2.setOnClickListener {
            startActivity(Intent(this, MapsActivity::class.java))
        }

        kiri2.setOnClickListener {
            startActivity(Intent(this, ProductListActivity::class.java))
        }


    }
}
