package com.example.android.jetpackcomposeweather.ui.componets.main_screen

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.android.jetpackcomposeweather.ui.componets.error_screen.ErrorScreen
import com.example.android.jetpackcomposeweather.ui.componets.loading_screen.LoadingScreen

@Composable
fun FavoriteCityCardContent(cityName: String) {

    val viewModel = hiltViewModel<MainViewModel>()

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        AsyncImage(
            model = viewModel.favoriteCityImage,
            contentScale = ContentScale.Crop,
            contentDescription = " City image",
            modifier = Modifier
                .clip(CircleShape)
                .border(BorderStroke(3.dp, Color.Black), CircleShape)
                .size(140.dp)
        )


        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = "New Zealand ")
            Text(
                text = cityName,
                style = MaterialTheme.typography.h4.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )

            when (viewModel.favoriteDetailsUiState) {

                is MainViewModel.FavoriteDetailsUiState.Loading -> LoadingScreen()

                is MainViewModel.FavoriteDetailsUiState.Success -> FavoriteDetailsContent((viewModel.favoriteDetailsUiState as MainViewModel.FavoriteDetailsUiState.Success).weather)

                is MainViewModel.FavoriteDetailsUiState.Error -> ErrorScreen()
            }

        }

    }
}

@Composable
private fun FavoriteDetailsContent(contentModelDTO: MainViewModel.FavoriteCityModel) {

    Text(
        text = "Temperature ${contentModelDTO.temp}°C",
        style = MaterialTheme.typography.h6,
        modifier = Modifier.padding(top = 10.dp)
    )
    Text(
        text = "Wind speed ${contentModelDTO.windSpeed} m/s",
        style = MaterialTheme.typography.h6
    )
    contentModelDTO.condition?.let {
        Text(text = it, style = MaterialTheme.typography.h6)
    }
}