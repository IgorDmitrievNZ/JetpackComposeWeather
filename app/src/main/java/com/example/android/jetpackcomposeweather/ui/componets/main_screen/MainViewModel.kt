package com.example.android.jetpackcomposeweather.ui.componets.main_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var isNorth by mutableStateOf(true)
    var favoriteCityName by mutableStateOf("Auckland")
    var favoriteCityImage by mutableStateOf("https://lh6.googleusercontent.com/wVwTqqrvITsmOJFh7ZfkPVpPpLkerDh8aNLgX_Af4Qe42sLG6GpRWru7Xxb-Dqy1O1-lu39HWrPXzLW4hikiWZHi8D-b-9ZKkfgTc6cKHPf6iFdE04znARRBHWOXrR4eiDCV6QW2Fm5C7pIproYnOm_Z6hoRKnfhTBk_dVnK_kF7LTZsuPn6wMvr")
}