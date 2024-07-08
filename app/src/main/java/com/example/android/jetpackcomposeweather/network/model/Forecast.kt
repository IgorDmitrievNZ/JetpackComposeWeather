package com.example.android.jetpackcomposeweather.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Forecast(
    val date: String?,
    @SerialName("date_ts") val dateTs: Int?,
    @SerialName("moon_code") val moonCode: Int?,
    @SerialName("moon_text") val moonText: String?,
    val parts: List<Part?>?,
    val sunrise: String?,
    val sunset: String?,
    val week: Int?
)