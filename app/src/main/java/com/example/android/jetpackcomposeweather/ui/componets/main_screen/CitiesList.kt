package com.example.android.jetpackcomposeweather.ui.componets.main_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.android.jetpackcomposeweather.repository.WeatherModel

@Composable
fun CitiesList(names: List<WeatherModel>, navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .padding(vertical = 4.dp)
    ) {
        items(items = names) { item ->
            CityCard(cityName = item.city.city, navController)
        }
    }
}