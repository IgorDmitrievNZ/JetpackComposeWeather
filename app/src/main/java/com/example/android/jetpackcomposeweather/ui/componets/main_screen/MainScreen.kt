package com.example.android.jetpackcomposeweather.ui.componets.main_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.android.jetpackcomposeweather.repository.City

@Composable
fun MainScreen(navController: NavController) {

    // A surface container using the 'background' color from the theme
    Surface(color = MaterialTheme.colors.background) {

        val isNorth = remember {
            mutableStateOf(true)
        }

        CitiesList(
            if (isNorth.value) City.getNorthCities() else City.getSouthCities(),
            navController = navController
        )

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