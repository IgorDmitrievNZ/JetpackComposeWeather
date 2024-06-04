package com.example.android.jetpackcomposeweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.android.jetpackcomposeweather.ui.theme.JetpackComposeWeatherTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            JetpackComposeWeatherTheme {
                Navigation()
            }
        }
    }
}