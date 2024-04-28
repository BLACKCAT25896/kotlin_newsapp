package com.example.kotlinbaba.Models

data class Tag(
    val created_at: String,
    val id: Int,
    val pivot: Pivot,
    val tag: String,
    val updated_at: String,
    val visit_count: Int
)