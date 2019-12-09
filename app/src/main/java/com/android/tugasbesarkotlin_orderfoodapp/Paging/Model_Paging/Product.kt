package com.android.tugasbesarkotlin_orderfoodapp.Paging.Model_Paging

import com.google.gson.annotations.SerializedName

data class Product(

    @field:SerializedName("name_product")
    val name_product: String? = null,

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("price")
    val price: String? = null,

    @field:SerializedName("updated_at")
    val updated_at: Any? = null,

    @field:SerializedName("created_at")
    val created_at: Any? = null,

    @field:SerializedName("id")
    val id: Int? = null
)