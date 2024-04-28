package com.example.kotlinbaba.Models

data class Shop(
    val address: String,
    val banner: String,
    val bottom_banner: Any,
    val contact: String,
    val created_at: String,
    val id: Int,
    val image: String,
    val name: String,
    val offer_banner: Any,
    val seller_id: Int,
    val slug: String,
    val temporary_close: Boolean,
    val updated_at: String,
    val vacation_end_date: String,
    val vacation_note: Any,
    val vacation_start_date: String,
    val vacation_status: Boolean
)