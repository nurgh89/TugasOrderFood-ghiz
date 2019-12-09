package com.android.tugasbesarkotlin_orderfoodapp

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import com.android.tugasbesarkotlin_orderfoodapp.Databse.DatabaseUser
import com.android.tugasbesarkotlin_orderfoodapp.Databse.UserDao
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignIn : AppCompatActivity() {

    lateinit var animationDrawable: AnimationDrawable

    private var progrressDialog: ProgressDialog? = null
    private  var userDao: UserDao? = null
    private  var database: DatabaseUser? = null


    private  var txt_email: TextView? = null
    private  var txt_passwword:TextView? = null
    private  var btn_masuk:Button? = null
    private  var Godaftar:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        animationDrawable = layeranimation_splash.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(3000)
        animationDrawable.setExitFadeDuration(3000)
        animationDrawable.start()


        goDaftar.setOnClickListener {

            startActivity(Intent(this@SignIn, SignUp::class.java))

        }

        progrressDialog = ProgressDialog(this)
        progrressDialog!!.setCancelable(false)
        progrressDialog!!.setMessage("Checking...")
        progrressDialog!!.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
        progrressDialog!!.progress = 0


        database = Room.databaseBuilder(this, DatabaseUser::class.java!!, "starbucks.db")
            .allowMainThreadQueries()
            .build()


        userDao = database!!.userDao

        txt_email = findViewById(R.id.add_emaillogin)
        txt_passwword = findViewById(R.id.add_paswordlogin)
        btn_masuk = findViewById(R.id.btn_signIn)


        btn_masuk!!.setOnClickListener {
            if (!emptyValidation()){
                progrressDialog!!.show()
                Handler().postDelayed({
                    val user = userDao!!.getUser(txt_email!!.text.toString(), txt_passwword!!.text.toString())
                    if (user != null){
                        val i = Intent (this, Dashboard::class.java)
                        i.putExtra("User", user)
                        startActivity(i)
                        finish()
                    }else{
                        Toast.makeText(this, "email atau password salah", Toast.LENGTH_SHORT).show()
                    }
                    progrressDialog!!.dismiss()

                }, 10000)
            }else{
                Toast.makeText(this,"Kolom Harus di isi ", Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun emptyValidation(): Boolean {
        return (TextUtils.isEmpty(txt_email!!.text.toString()) || TextUtils.isEmpty(txt_passwword!!.text.toString()))

    }
}
