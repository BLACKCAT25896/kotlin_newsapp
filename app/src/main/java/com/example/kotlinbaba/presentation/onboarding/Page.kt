package com.example.kotlinbaba.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.kotlinbaba.R

data class Page(
    val title : String,
    val description : String,
    @DrawableRes val image : Int

)

val pages = listOf(
    Page(
        title = "Welcome to Kotlin Baba",
        description = "This is the description of the first page",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Welcome to Kotlin Baba",
        description = "This is the description of the second page",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Welcome to Kotlin Baba",
        description = "This is the description of the third page",
        image = R.drawable.onboarding3
    ),

)
