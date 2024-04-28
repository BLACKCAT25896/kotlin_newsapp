package com.example.kotlinbaba.Models

data class ProductModel(
    val limit: Int,
    val offset: Int,
    val products: List<Product>,
    val total_size: Int
)