package com.example.android.jetpackcomposeweather.ui.componets.main_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.jetpackcomposeweather.datastore.StoreFavoriteCity
import com.example.android.jetpackcomposeweather.network.model.WeatherDTO
import com.example.android.jetpackcomposeweather.repository.Repository
import com.example.android.jetpackcomposeweather.repository.model.City
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    private val dataStoreFavoriteCity: StoreFavoriteCity
) : ViewModel() {

    var isNorth by mutableStateOf(true)
    var favoriteCityName by mutableStateOf("")
    var favoriteCityImage by mutableStateOf("")
    var favoriteDetailsUiState: FavoriteDetailsUiState by mutableStateOf(FavoriteDetailsUiState.Loading)
        private set

    data class FavoriteCityModel(
        val temp: Int?,
        val condition: String?,
        val windSpeed: Double?
    )

    init {
        //first to get city name from data store(Auckland is default when the App loads very firs time)
        retrieveData()
    }

    private fun saveData(value: String) {
        viewModelScope.launch {
            dataStoreFavoriteCity.saveCityName(value)
        }
    }

    private fun retrieveData() {
        // get city name from data store (shared preferences)
        dataStoreFavoriteCity.getCityName.onEach {
            // find the actual city by name
            val city = City.getNorthCities().find { item -> item.city.city == it }
                ?: City.getSouthCities()
                    .find { item -> item.city.city == it }
            if (city != null) {
                updateFavoriteCity(city.city)
            }
        }.launchIn(viewModelScope)
    }

    // updates favorite city
    private fun updateFavoriteCity(city: City) {
        // update name and image
        favoriteCityName = city.city
        favoriteCityImage = city.image
        // load details
        getDetails(city.lat, city.lon)
    }

    fun onFavoriteToggle(city: City) {
        updateFavoriteCity(city)
        saveData(city.city)
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