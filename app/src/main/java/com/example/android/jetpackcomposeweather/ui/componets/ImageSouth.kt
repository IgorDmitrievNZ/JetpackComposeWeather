package com.example.android.jetpackcomposeweather.ui.componets

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.android.jetpackcomposeweather.R

@Composable
fun ImageSouth(onSouthChange: () -> Unit) {
    val context = LocalContext.current

    Box(modifier = Modifier
        .padding(bottom = 20.dp, end = 20.dp)
        .border(BorderStroke(3.dp, Color.Black), CircleShape)
        .background(Color.White, CircleShape)
        .padding(15.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.south_map2),
            modifier = Modifier
                .size(70.dp)
                .clickable {
                    Toast
                        .makeText(
                            context,
                            "ImageSouth",
                            Toast.LENGTH_LONG
                        )
                        .show()
                    onSouthChange()
                },

            contentDescription = "South island picture",
            contentScale = ContentScale.Inside,

        )
    }
}