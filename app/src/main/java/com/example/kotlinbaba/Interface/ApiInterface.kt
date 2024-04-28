package com.example.kotlinbaba.Interface

import com.example.kotlinbaba.Models.ProductModel
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    @GET("api/v1/products/latest?guest_id=1&limit=10&&offset=1")
    fun getProduct() : Call<ProductModel>
}