package com.example.kotlinbaba.Models

data class FlashDealProduct(
    val created_at: String,
    val discount: String,
    val discount_type: Any,
    val flash_deal: FlashDeal,
    val flash_deal_id: Int,
    val id: Int,
    val product_id: Int,
    val updated_at: String
)