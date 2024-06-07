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
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

@Composable
fun DetailScreen() {

    val viewModel = viewModel<DetailsViewModel>()

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
        Text(modifier = Modifier.padding(5.dp), text = "City ${viewModel.cityName}")
        Text(
            modifier = Modifier.padding(5.dp),
            text = "Condition ${viewModel.cityModel?.condition}"
        )
        Text(
            modifier = Modifier.padding(5.dp),
            text = "Temperature ${viewModel.cityModel?.temperature}"
        )
        Text(
            modifier = Modifier.padding(5.dp),
            text = "Fills like ${viewModel.cityModel?.feelsLike}"
        )
    }
}