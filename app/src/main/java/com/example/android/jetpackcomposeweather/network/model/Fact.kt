package com.example.android.jetpackcomposeweather.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Fact(
    val condition: String?,
    val daytime: String?,
    @SerialName("feels_like") val feelsLike: Int?,
    val humidity: Int?,
    val icon: String?,
    @SerialName("obs_time") val obsTime: Int?,
    val polar: Boolean?,
    @SerialName("pressure_mm") val pressureMm: Int?,
    @SerialName("pressure_pa") val pressurePa: Int?,
    val season: String?,
    val temp: Int?,
    @SerialName("temp_water") val tempWater: Int?,
    @SerialName("wind_dir") val windDir: String?,
    @SerialName("wind_gust") val windGust: Double?,
    @SerialName("wind_speed") val windSpeed: Double?
)