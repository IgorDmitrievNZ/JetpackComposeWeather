package com.example.android.jetpackcomposeweather.repository.model

import android.os.Parcelable
import com.example.android.jetpackcomposeweather.repository.model.City
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherModel(
    var city: City = City.getDefaultCity(),
    val temperature: Int = 0,
    val feelsLike: Int = 0,
    val condition: String? = "none"
) : Parcelable


