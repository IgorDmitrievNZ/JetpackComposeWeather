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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun MainCityCardContent(cityName: String) {
    Row(
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
            model = "https://lh6.googleusercontent.com/wVwTqqrvITsmOJFh7ZfkPVpPpLkerDh8aNLgX_Af4Qe42sLG6GpRWru7Xxb-Dqy1O1-lu39HWrPXzLW4hikiWZHi8D-b-9ZKkfgTc6cKHPf6iFdE04znARRBHWOXrR4eiDCV6QW2Fm5C7pIproYnOm_Z6hoRKnfhTBk_dVnK_kF7LTZsuPn6wMvr",
            contentScale = ContentScale.Crop,
            contentDescription = " City image",
            modifier = Modifier
                .clip(CircleShape)
                .border(BorderStroke(3.dp, Color.Black), CircleShape)
                .size(150.dp)
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
            Text(
                text = "Temperature 22°C",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(top = 10.dp)
            )
            Text(
                text = "Wind speed 10 m/s",
                style = MaterialTheme.typography.h6
            )
            Text(
                text = "Cloudy",
                style = MaterialTheme.typography.h6
            )
        }

    }
}