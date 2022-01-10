package com.example.android.jetpackcomposeweather.repository

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weather(
    var city: City = City.getDefaultCity(),
    val temperature: Int = 0,
    val feelsLike: Int = 0,
    val condition: String? = "none"
) : Parcelable


