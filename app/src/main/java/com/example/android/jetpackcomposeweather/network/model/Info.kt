package com.example.android.jetpackcomposeweather.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Info(
    val lat: Double?,
    val lon: Double?,
    val url: String?
)