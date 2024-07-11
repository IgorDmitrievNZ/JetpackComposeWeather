package com.example.android.jetpackcomposeweather.ui.componets.main_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.android.jetpackcomposeweather.repository.model.City

@Composable
fun MainScreen(navController: NavController) {

    // A surface container using the 'background' color from the theme
    Surface(color = MaterialTheme.colors.background) {

        val viewModel = viewModel<MainViewModel>()

        Column {
            MainCityCard(viewModel.favoriteCity)
            CitiesList(
                if (viewModel.isNorth) City.getNorthCities() else City.getSouthCities(),
                navController = navController,
            )
        }

        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.fillMaxSize(),
        ) {
            ImageNorth { viewModel.isNorth = true }
            ImageSouth { viewModel.isNorth = false }
        }
    }
}