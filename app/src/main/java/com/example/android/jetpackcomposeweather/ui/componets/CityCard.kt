package com.example.android.jetpackcomposeweather.ui.componets

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun CityCard(cityName: String) {
    val context = LocalContext.current

    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clickable {
                Toast
                    .makeText(context, cityName, Toast.LENGTH_LONG)
                    .show()
            }
    ) {
        CardContent(cityName)
    }
}