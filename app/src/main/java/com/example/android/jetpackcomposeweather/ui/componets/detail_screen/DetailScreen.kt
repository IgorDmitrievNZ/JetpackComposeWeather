package com.example.android.jetpackcomposeweather.ui.componets.detail_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun DetailScreen() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(
            model = "https://www.newzealand.com/assets/Tourism-NZ/Auckland/98618569ff/img-1536065871-6217-4403-p-10D1D0BD-B88E-AAB3-AE3F2E903EF65717-2544003__aWxvdmVrZWxseQo_CropResizeWzE5MDAsMTAwMCw3NSwianBnIl0.jpg",
            contentDescription = "Auckland default"
        )
        Text(modifier = Modifier.padding(5.dp), text = "City")
        Text(modifier = Modifier.padding(5.dp), text = "Condition")
        Text(modifier = Modifier.padding(5.dp), text = "Temperature")
        Text(modifier = Modifier.padding(5.dp), text = "Fills like")
    }
}