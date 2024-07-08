package com.example.android.jetpackcomposeweather.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherDTO(
    val fact: Fact?,
    val forecast: Forecast?,
    val info: Info?,
    val now: Int?,
    @SerialName("now_dt") val nowDt: String?
)