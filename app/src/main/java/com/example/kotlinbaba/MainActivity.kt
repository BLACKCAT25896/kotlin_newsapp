package com.example.kotlinbaba
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kotlinbaba.domain.useCases.AppEntryUseCases
import com.example.kotlinbaba.presentation.onboarding.OnBoardingScreen
import com.example.kotlinbaba.presentation.onboarding.OnBoardingViewModel
import com.example.kotlinbaba.ui.theme.KotlinbabaTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var appEntryUseCases: AppEntryUseCases
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()

//        lifecycleScope.launch {
////            appEntryUseCases.readAppEntry().collect(){
////                Log.d("TAG", "onCreate: $it")
////            }
//        }
        setContent {
            KotlinbabaTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)){
                    val viewModel : OnBoardingViewModel = hiltViewModel()
                    OnBoardingScreen(event =  viewModel::onEvent )
                }


            }
        }

    }
}
