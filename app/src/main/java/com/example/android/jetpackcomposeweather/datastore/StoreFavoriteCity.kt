package com.example.android.jetpackcomposeweather.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreFavoriteCity (private val context: Context) {
    // to make sure there is only one instance
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("CityName")
        val CITY_NAME_KEY = stringPreferencesKey("city_name")
    }

    // to get the city name
    // default city - Auckland
    val getCityName: Flow<String> = context.dataStore.data
        .map { preferences ->
            preferences[CITY_NAME_KEY] ?: "Auckland"
        }

    // to save the city name
    suspend fun saveCityName(name: String) {
        context.dataStore.edit { preferences ->
            preferences[CITY_NAME_KEY] = name
        }
    }
}