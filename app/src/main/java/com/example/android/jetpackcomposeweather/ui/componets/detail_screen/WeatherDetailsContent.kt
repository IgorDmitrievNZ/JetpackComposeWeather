package com.example.android.jetpackcomposeweather.ui.componets.detail_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

@Composable
fun WeatherDetailsContent(detailsDTO: DetailsViewModel.WeatherDetailsModel) {

    val viewModel = hiltViewModel<DetailsViewModel>()

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(
            model = viewModel.cityModel?.city?.image,
            contentScale = ContentScale.Crop,
            contentDescription = " City image",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .padding(5.dp)
        )
        Text(modifier = Modifier.padding(5.dp),
            text = "City ${viewModel.cityName}")
        Text(
            modifier = Modifier.padding(5.dp),
            text = "Condition ${detailsDTO.condition}"
        )
        Text(
            modifier = Modifier.padding(5.dp),
            text = "Temperature ${detailsDTO.temp}"
        )
        Text(
            modifier = Modifier.padding(5.dp),
            text = "Fills like ${detailsDTO.feelsLike}"
        )
        Text(
            modifier = Modifier.padding(5.dp),
            text = "Humidity ${detailsDTO.humidity} %"
        )
        Text(
            modifier = Modifier.padding(5.dp),
            text = "Wind direction ${detailsDTO.windDir}"
        )
        Text(
            modifier = Modifier.padding(5.dp),
            text = "Wind speed ${detailsDTO.windSpeed} meters per second"
        )
    }
}