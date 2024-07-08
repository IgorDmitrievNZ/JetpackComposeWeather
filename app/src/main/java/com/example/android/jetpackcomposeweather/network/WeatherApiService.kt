package com.example.android.jetpackcomposeweather.network

import com.example.android.jetpackcomposeweather.BuildConfig
import com.example.android.jetpackcomposeweather.network.model.WeatherDTO
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WeatherApiService {

    @Headers("X-Yandex-API-Key: ${BuildConfig.WEATHER_API_KEY}")
    @GET("informers")
    suspend fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): WeatherDTO
}