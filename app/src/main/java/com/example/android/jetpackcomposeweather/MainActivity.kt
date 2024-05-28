package com.example.android.jetpackcomposeweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.android.jetpackcomposeweather.repository.City
import com.example.android.jetpackcomposeweather.ui.componets.CitiesList
import com.example.android.jetpackcomposeweather.ui.componets.ImageNorth
import com.example.android.jetpackcomposeweather.ui.componets.ImageSouth
import com.example.android.jetpackcomposeweather.ui.theme.JetpackComposeWeatherTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeWeatherTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    val isNorth = remember {
                        mutableStateOf(true)
                    }

                    CitiesList(if (isNorth.value) City.getNorthCities() else City.getSouthCities())

                    Column(
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.Bottom,
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        ImageNorth() { isNorth.value = true }
                        ImageSouth() { isNorth.value = false }
                    }
                }
            }
        }
    }
}