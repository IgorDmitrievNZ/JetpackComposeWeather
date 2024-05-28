package com.example.android.jetpackcomposeweather.ui.componets

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.android.jetpackcomposeweather.repository.Weather

@Composable
fun CitiesList(names: List<Weather>) {
    LazyColumn(
        modifier = Modifier
            .padding(vertical = 4.dp)
    ) {
        items(items = names) { name ->
            CityCard(cityName = name.city.city)
        }
    }
}