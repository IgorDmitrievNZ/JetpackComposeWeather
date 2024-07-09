package com.example.android.jetpackcomposeweather.ui.componets.detail_screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.android.jetpackcomposeweather.repository.model.City
import com.example.android.jetpackcomposeweather.repository.model.WeatherModel

class DetailsViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    val cityName: String = checkNotNull(savedStateHandle["city"])

    val cityModel: WeatherModel? =
        City.getNorthCities().find { item -> item.city.city == cityName } ?: City.getSouthCities()
            .find { item -> item.city.city == cityName }

}