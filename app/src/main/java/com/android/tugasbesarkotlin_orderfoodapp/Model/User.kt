package com.android.tugasbesarkotlin_orderfoodapp.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class User(var email : String?, var username : String?, var password :String?) : Serializable {

    @PrimaryKey(autoGenerate = true)
    var id:Int = 0

    override fun toString(): String {
        return "User{" +
                "id=" + id +
                ", email= '" + email + '\''.toString() +
                ", username= '" + username + '\''.toString() +
                ", password= '" + password + '\''.toString() +
                '}'.toString()

       }
    }

