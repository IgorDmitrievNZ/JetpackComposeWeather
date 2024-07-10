package com.example.android.jetpackcomposeweather.ui.componets.detail_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.jetpackcomposeweather.network.model.WeatherDTO
import com.example.android.jetpackcomposeweather.repository.Repository
import com.example.android.jetpackcomposeweather.repository.model.City
import com.example.android.jetpackcomposeweather.repository.model.WeatherModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: Repository
) : ViewModel() {

    val cityName: String = checkNotNull(savedStateHandle["city"])

    var detailsUiState: DetailsUiState by mutableStateOf(DetailsUiState.Loading)
        private set

    val cityModel: WeatherModel? =
        City.getNorthCities().find { item -> item.city.city == cityName } ?: City.getSouthCities()
            .find { item -> item.city.city == cityName }


    data class WeatherDetailsModel(
        val temp: Int?,
        val feelsLike: Int?,
        val condition: String?,
        val humidity: Int?,
        val windDir: String?,
        val windSpeed: Double?
    )

    init {
        cityModel?.city?.let { getDetails(cityModel.city.lat, it.lon) }
    }

    private fun getDetails(lat: Double, lon: Double) {
        viewModelScope.launch {
            detailsUiState = DetailsUiState.Loading
            detailsUiState = try {
                val detailsResult: WeatherDTO = repository.getWeatherFromServer(lat, lon)
                val details = WeatherDetailsModel(
                    temp = detailsResult.fact?.temp,
                    feelsLike = detailsResult.fact?.feelsLike,
                    condition = detailsResult.fact?.condition,
                    humidity = detailsResult.fact?.humidity,
                    windDir = detailsResult.fact?.windDir,
                    windSpeed = detailsResult.fact?.windSpeed
                )
                DetailsUiState.Success(details)
            } catch (e: IOException) {
                DetailsUiState.Error
            } catch (e: HttpException) {
                DetailsUiState.Error
            }
        }
    }

    sealed interface DetailsUiState {
        data class Success(val weather: WeatherDetailsModel) : DetailsUiState
        data object Error : DetailsUiState
        data object Loading : DetailsUiState
    }
}