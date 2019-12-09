package com.android.tugasbesarkotlin_orderfoodapp

import android.app.ProgressDialog

import android.content.Intent
import android.graphics.drawable.AnimationDrawable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils

import android.widget.Button
import android.widget.Toast
import androidx.room.Room
import com.android.tugasbesarkotlin_orderfoodapp.Databse.DatabaseUser
import com.android.tugasbesarkotlin_orderfoodapp.Databse.UserDao
import com.android.tugasbesarkotlin_orderfoodapp.Model.User
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_sign_up.*

import java.util.logging.Handler as Handler1

class SignUp : AppCompatActivity() {

    lateinit var animationDrawable: AnimationDrawable

    private var username: TextInputEditText? = null
    private var email: TextInputEditText? = null
    private var password: TextInputEditText? = null
    private var daftar: Button? = null

    private var userDao: UserDao? = null
    private var progressDialog: ProgressDialog? = null

    private val isEmpty: Boolean
        get() = (TextUtils.isEmpty(username!!.text.toString())
                || TextUtils.isEmpty(email!!.text.toString())
                || TextUtils.isEmpty(password!!.text.toString()))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        animationDrawable = layeranimation_splash.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(3000)
        animationDrawable.setExitFadeDuration(3000)
        animationDrawable.start()


        progressDialog = ProgressDialog(this)
        progressDialog!!.setCancelable(false)
        progressDialog!!.setMessage("Prosess...")
        progressDialog!!.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
        progressDialog!!.progress = 0

        email = findViewById(R.id.add_email_daftar)
        username = findViewById(R.id.add_usernamedaftar)
        password = findViewById(R.id.add_password)

        userDao = Room.databaseBuilder(this, DatabaseUser::class.java!!, "starbucks.db")
            .allowMainThreadQueries()
            .build()
            .userDao

        daftar = findViewById(R.id.btn_daftar)
        daftar!!.setOnClickListener {

            if (!isEmpty) {

                progressDialog!!.show()

                Handler().postDelayed({
                    val user = User(

                        username!!.text.toString(),
                        email!!.text.toString(),
                        password!!.text.toString()

                    )
                    userDao!!.insert(user)
                    progressDialog!!.dismiss()
                    startActivity(Intent(this@SignUp, SignIn::class.java))

                }, 1000)
            } else {
                Toast.makeText(this, "mohon periksa kembali", Toast.LENGTH_SHORT).show()
            }

        }

    }

}