package com.android.tugasbesarkotlin_orderfoodapp.Paging.Netwoking

import com.android.tugasbesarkotlin_orderfoodapp.Paging.Model_Paging.Product
import com.google.gson.annotations.SerializedName

data class Response(
    @field:SerializedName("product")
    val product: List<Product>


)

