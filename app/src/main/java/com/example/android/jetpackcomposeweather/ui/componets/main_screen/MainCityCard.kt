package com.example.android.jetpackcomposeweather.ui.componets.main_screen

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainCityCard(chosenCity: String) {
    Card(
        backgroundColor = MaterialTheme.colors.secondaryVariant,
        modifier = Modifier
            .fillMaxHeight(0.35f)
            .padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        MainCityCardContent(cityName = chosenCity)
    }
}