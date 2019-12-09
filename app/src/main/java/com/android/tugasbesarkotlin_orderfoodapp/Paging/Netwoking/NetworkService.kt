package com.android.tugasbesarkotlin_orderfoodapp.Paging.Netwoking

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("product")
     fun getNews(@Query("page")page :Int,
                 @Query("pageSize") pageSize: Int) : Single<Response>


    companion object{
        fun getService(): NetworkService{
            val retrofit = Retrofit.Builder()
                .baseUrl("http://172.16.10.65/starbuck/public/api/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(NetworkService::class.java)
        }
    }


}