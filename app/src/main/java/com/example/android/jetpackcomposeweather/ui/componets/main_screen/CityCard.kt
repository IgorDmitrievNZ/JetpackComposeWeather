package com.example.android.jetpackcomposeweather.ui.componets.main_screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.android.jetpackcomposeweather.repository.model.City
import com.example.android.jetpackcomposeweather.utils.Screen

@Composable
fun CityCard(city: City, navController: NavController) {
    val context = LocalContext.current

    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clickable {
                Toast
                    .makeText(context, city.city, Toast.LENGTH_LONG)
                    .show()
                navController.navigate(Screen.DetailsScreen.withArgs(city.city))
            }
    ) {
        CardContent(city)
    }
}