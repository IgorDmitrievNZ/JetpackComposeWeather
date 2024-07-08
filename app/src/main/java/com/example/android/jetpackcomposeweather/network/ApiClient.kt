package com.example.android.jetpackcomposeweather.network

import com.example.android.jetpackcomposeweather.network.NetworkDataSource.retrofit

object ApiClient {
    val retrofitService: WeatherApiService by lazy {
        retrofit.create(WeatherApiService::class.java)
    }
}