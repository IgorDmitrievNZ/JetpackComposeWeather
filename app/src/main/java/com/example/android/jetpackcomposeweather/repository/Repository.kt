package com.example.android.jetpackcomposeweather.repository

import com.example.android.jetpackcomposeweather.network.ApiClient
import com.example.android.jetpackcomposeweather.network.model.WeatherDTO
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor() {

    suspend fun getWeatherFromServer(lat: Double, lon: Double): WeatherDTO {
        return ApiClient.retrofitService.getWeather(lat, lon)
    }
}