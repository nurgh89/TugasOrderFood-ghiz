package com.android.tugasbesarkotlin_orderfoodapp.Databse

import androidx.room.*
import com.android.tugasbesarkotlin_orderfoodapp.Model.User


@Dao
interface UserDao {
    @Query("SELECT * FROM User where email= :email and password= :password" )
    fun getUser (email:String, password: String): User

    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)
}