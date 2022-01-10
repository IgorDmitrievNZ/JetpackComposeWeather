package com.example.android.jetpackcomposeweather.repository

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class City(
    val city: String
) : Parcelable {
    companion object {
        fun getDefaultCity() = City("Auckland")

        fun getSouthCities() = listOf(
            Weather(City("Nelson")),
            Weather(City("Blenheim")),
            Weather(City("Picton")),
            Weather(City("Westport")),
            Weather(City("Christchurch")),
            Weather(City("Queenstown")),
            Weather(City("Invercargill")),
            Weather(City("Dunedin")),
        )

        fun getNorthCities() = listOf(
            Weather(City("Auckland")),
            Weather(City("Wellington")),
            Weather(City("Whangarei")),
            Weather(City("Tauranga")),
            Weather(City("Hamilton")),
            Weather(City("Taupo")),
            Weather(City("Rotorua")),
            Weather(City("Gisborne")),
            Weather(City("Napier")),
            Weather(City("Palmerston North")),
            Weather(City("Masterton")),
            Weather(City("Lower Hutt")),
            Weather(City("New Plymouth"))
        )
    }
}

