package com.example.android.jetpackcomposeweather

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.jetpackcomposeweather.repository.City
import com.example.android.jetpackcomposeweather.repository.Weather
import com.example.android.jetpackcomposeweather.ui.theme.JetpackComposeWeatherTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeWeatherTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    CitiesList()
                    Column(
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.Bottom,
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        ImageNorth()
                        ImageSouth()
                    }
                }
            }
        }
    }
}

@Composable
private fun CardContent(name: String) {

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
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = "New Zealand ")
            Text(
                text = name,
                style = MaterialTheme.typography.h4.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
        }

    }
}

@Composable
private fun CityCard(cityName: String) {
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

@Composable
private fun CitiesList(names: List<Weather> = City.getNorthCities()) {
    LazyColumn(
        modifier = Modifier
            .padding(vertical = 4.dp)
    ) {
        items(items = names) { name ->
            CityCard(cityName = name.city.city)
        }
    }
}

@Composable
fun ImageNorth() {
    val context = LocalContext.current

    Box(modifier = Modifier.padding(bottom = 4.dp)) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .clickable {
                    Toast
                        .makeText(context, "ImageNorth", Toast.LENGTH_LONG)
                        .show()
                },
            painter = painterResource(R.drawable.north),
            contentDescription = "Contact profile picture",
        )
    }
}

@Composable
fun ImageSouth() {
    val context = LocalContext.current

    Image(
        modifier = Modifier
            .size(50.dp)
            .clickable {
                Toast
                    .makeText(
                        context,
                        "ImageSouth",
                        Toast.LENGTH_LONG
                    )
                    .show()
            },
        painter = painterResource(R.drawable.south),
        contentDescription = "Contact profile picture",
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeWeatherTheme {
        CityCard("City Name")
    }
}