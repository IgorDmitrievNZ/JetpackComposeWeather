package com.example.android.jetpackcomposeweather.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Part(
    val condition: String?,
    val daytime: String?,
    @SerialName("feels_like") val feelsLike: Int?,
    val humidity: Int?,
    val icon: String?,
    @SerialName("part_name") val partName: String?,
    val polar: Boolean?,
    @SerialName("prec_mm") val precMm: Int?,
    @SerialName("prec_period") val precPeriod: Int?,
    @SerialName("prec_prob") val precProb: Int?,
    @SerialName("pressure_mm") val pressureMm: Int?,
    @SerialName("pressure_pa") val pressurePa: Int?,
    @SerialName("temp_avg") val tempAvg: Int?,
    @SerialName("temp_max") val tempMax: Int?,
    @SerialName("temp_min") val tempMin: Int?,
    @SerialName("temp_water") val tempWater: Int?,
    @SerialName("wind_dir") val windDir: String?,
    @SerialName("wind_gust") val windGust: Double?,
    @SerialName("wind_speed") val windSpeed: Double?
)