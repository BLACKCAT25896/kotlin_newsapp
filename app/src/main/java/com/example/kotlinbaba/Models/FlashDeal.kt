package com.example.kotlinbaba.Models

data class FlashDeal(
    val background_color: Any,
    val banner: String,
    val created_at: String,
    val deal_type: String,
    val end_date: String,
    val featured: Boolean,
    val id: Int,
    val product_id: Any,
    val slug: String,
    val start_date: String,
    val status: Boolean,
    val text_color: Any,
    val title: String,
    val translations: List<Any>,
    val updated_at: String
)