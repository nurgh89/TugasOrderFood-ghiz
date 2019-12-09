package com.android.tugasbesarkotlin_orderfoodapp.Databse

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.tugasbesarkotlin_orderfoodapp.Model.User


@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class DatabaseUser : RoomDatabase(){

    abstract val userDao: UserDao
}