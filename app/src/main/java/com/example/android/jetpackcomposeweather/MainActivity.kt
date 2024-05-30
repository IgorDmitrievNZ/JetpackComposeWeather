package com.example.android.jetpackcomposeweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.android.jetpackcomposeweather.ui.componets.detail_screen.DetailScreen
import com.example.android.jetpackcomposeweather.ui.componets.main_screen.MainScreen
import com.example.android.jetpackcomposeweather.ui.theme.JetpackComposeWeatherTheme
import com.example.android.jetpackcomposeweather.utils.Screen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            JetpackComposeWeatherTheme {

                //main screen route
                NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
                    composable(Screen.MainScreen.route) {
                        MainScreen(navController = navController)
                    }

                    //route to details
                    composable(Screen.DetailsScreen.route + "/{city}",
                        arguments = listOf(
                            navArgument("city") {
                                type = NavType.StringType
                                defaultValue = "Auckland"
                                nullable = true
                            }
                        )
                    ) {
                        DetailScreen()
                    }

                    //next route here
                }
            }
        }
    }
}