package com.example.kotlinbaba.presentation.onboarding.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.kotlinbaba.utill.Dimension.indicatorSize

@Composable
fun PageIndicator(modifier: Modifier = Modifier,
                  selectedPageColor: Color = MaterialTheme.colorScheme.primary,
                  unSelectedPageColor: Color = Color.Gray,
                   currentPage: Int,
                   totalPages: Int){
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(totalPages){
            page -> Box(modifier = Modifier.size(indicatorSize).clip(CircleShape)
                .background(color = if(page == currentPage) selectedPageColor else unSelectedPageColor))
        }
    }

}