package com.example.android.jetpackcomposeweather.ui.componets.main_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    var isNorth by mutableStateOf(true)
    var favoriteCityName by mutableStateOf("Auckland")
    var favoriteCityImage by mutableStateOf("https://lh6.googleusercontent.com/wVwTqqrvITsmOJFh7ZfkPVpPpLkerDh8aNLgX_Af4Qe42sLG6GpRWru7Xxb-Dqy1O1-lu39HWrPXzLW4hikiWZHi8D-b-9ZKkfgTc6cKHPf6iFdE04znARRBHWOXrR4eiDCV6QW2Fm5C7pIproYnOm_Z6hoRKnfhTBk_dVnK_kF7LTZsuPn6wMvr")
    var favoriteCityTemp by mutableIntStateOf(0)
    var favoriteCityCondition by mutableStateOf("")
    var favoriteCityWindSpeed by mutableDoubleStateOf(0.0)
    var favoriteDetailsUiState: FavoriteDetailsUiState by mutableStateOf(FavoriteDetailsUiState.Loading)
        private set

    private val cityModel: WeatherModel? =
        City.getNorthCities().find { item -> item.city.city == favoriteCityName }
            ?: City.getSouthCities()
                .find { item -> item.city.city == favoriteCityName }

    data class FavoriteCityModel(
        val temp: Int?,
        val condition: String?,
        val windSpeed: Double?
    )

    init {
        cityModel?.city?.let { getDetails(cityModel.city.lat, it.lon) }
    }

    private fun getDetails(lat: Double, lon: Double) {
        viewModelScope.launch {
            favoriteDetailsUiState = FavoriteDetailsUiState.Loading
            favoriteDetailsUiState = try {
                val detailsResult: WeatherDTO = repository.getWeatherFromServer(lat, lon)
                val details = FavoriteCityModel(
                    temp = detailsResult.fact?.temp,
                    condition = detailsResult.fact?.condition,
                    windSpeed = detailsResult.fact?.windSpeed
                )
                FavoriteDetailsUiState.Success(details)
            } catch (e: IOException) {
                FavoriteDetailsUiState.Error
            } catch (e: HttpException) {
                FavoriteDetailsUiState.Error
            }
        }
    }

    sealed interface FavoriteDetailsUiState {
        data class Success(val weather: FavoriteCityModel) : FavoriteDetailsUiState
        data object Error : FavoriteDetailsUiState
        data object Loading : FavoriteDetailsUiState
    }
}