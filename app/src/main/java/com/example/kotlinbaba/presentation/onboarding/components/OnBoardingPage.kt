package com.example.kotlinbaba.presentation.onboarding.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinbaba.R
import com.example.kotlinbaba.utill.Dimension.defaultPadding
import com.example.kotlinbaba.utill.Dimension.smallPadding
import com.example.kotlinbaba.presentation.onboarding.Page
import com.example.kotlinbaba.presentation.onboarding.pages
import com.example.kotlinbaba.ui.theme.KotlinbabaTheme

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page : Page,
) {
    Column(modifier = modifier) {
        Image(modifier = modifier
            .fillMaxHeight(fraction = .715f).fillMaxSize()
            .fillMaxWidth(),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = page.image), contentDescription = null)
        
        Spacer(modifier = Modifier.height(defaultPadding))

        Text(text = page.title, modifier = Modifier.padding(horizontal = defaultPadding),
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.primary))
        Spacer(modifier = Modifier.height(smallPadding))
        Text(text = page.description, modifier = Modifier.padding(horizontal = defaultPadding),
            style = MaterialTheme.typography.bodyMedium, color = colorResource(id = R.color.primary))

    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun  onboardingPagePreview(){
    KotlinbabaTheme {
        OnBoardingPage(
            page = pages[0]
        )
    }
}