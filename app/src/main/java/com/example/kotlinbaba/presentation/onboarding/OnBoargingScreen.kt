package com.example.kotlinbaba.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.kotlinbaba.presentation.onboarding.common.NewsButton
import com.example.kotlinbaba.presentation.onboarding.common.NewsTextButton
import com.example.kotlinbaba.presentation.onboarding.common.PageIndicator
import com.example.kotlinbaba.presentation.onboarding.components.OnBoardingPage
import com.example.kotlinbaba.utill.Dimension.defaultPadding
import com.example.kotlinbaba.utill.Dimension.indicatorWidth
import com.example.kotlinbaba.utill.Dimension.smallPadding
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen (event: (OnBoardingEvent)-> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {

        val pagesState = rememberPagerState(initialPage = 0) {
            pages.size
        }
        val  buttonState = remember {
            derivedStateOf {
                when(pagesState.currentPage){
                    0-> listOf("", "Next")
                    1-> listOf("Back", "Next")
                    2-> listOf("Back", "Get Started")
                    else -> {
                        listOf("", "")
                    }
                }
            }
        }
        HorizontalPager(state = pagesState) {index -> OnBoardingPage(page = pages[index]) }
        Spacer(modifier = Modifier.height(indicatorWidth))

        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = defaultPadding)
            .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically){
            PageIndicator(modifier = Modifier.width(indicatorWidth),
                currentPage = pagesState.currentPage, totalPages = pages.size)

            Row (verticalAlignment = Alignment.CenterVertically){
                val scope = rememberCoroutineScope()
                if(buttonState.value[0].isNotEmpty()){

                    NewsTextButton(text = buttonState.value[0], onClick = {
                        scope.launch {
                            pagesState.animateScrollToPage(page = pagesState.currentPage -1)
                        }
                    })

                }
                Spacer(modifier = Modifier.width(smallPadding))
                NewsButton(text = buttonState.value[1], onClick = {
                    scope.launch {
                        if(pagesState.currentPage == 3){
                           event(OnBoardingEvent.SaveAppEntry)

                        }else{
                            pagesState.animateScrollToPage(page = pagesState.currentPage +1)
                        }

                    }
                })
            }
        }

    }
}