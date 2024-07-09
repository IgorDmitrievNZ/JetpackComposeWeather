package com.example.android.jetpackcomposeweather.ui.componets.detail_screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.android.jetpackcomposeweather.ui.componets.error_screen.ErrorScreen
import com.example.android.jetpackcomposeweather.ui.componets.loading_screen.LoadingScreen

@Composable
fun DetailScreen() {
    val viewModel = hiltViewModel<DetailsViewModel>()

    when (viewModel.detailsUiState) {

        is DetailsViewModel.DetailsUiState.Loading -> LoadingScreen()

        is DetailsViewModel.DetailsUiState.Success -> WeatherDetailsContent(
            (viewModel.detailsUiState as DetailsViewModel.DetailsUiState.Success).weather
        )

        is DetailsViewModel.DetailsUiState.Error -> ErrorScreen()
    }
}

