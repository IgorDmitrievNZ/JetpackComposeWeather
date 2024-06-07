package com.example.android.jetpackcomposeweather.repository

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class City(
    val city: String,
    val image: String,
    val lat: Double,
    val lon: Double
) : Parcelable {
    companion object {
        fun getDefaultCity() = City(
            "Default City",
            "https://www.newzealand.com/assets/Tourism-NZ/Auckland/98618569ff/img-1536065871-6217-4403-p-10D1D0BD-B88E-AAB3-AE3F2E903EF65717-2544003__aWxvdmVrZWxseQo_CropResizeWzE5MDAsMTAwMCw3NSwianBnIl0.jpg",
            -36.848461,
            174.763336
        )

        fun getSouthCities() = listOf(
            WeatherModel(
                City(
                    "Nelson",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/NZL-nelson-christ-church-turm.jpg/220px-NZL-nelson-christ-church-turm.jpg",
                    -41.270634,
                    173.283966
                )
            ),
            WeatherModel(
                City(
                    "Picton",
                    "https://upload.wikimedia.org/wikipedia/commons/b/bf/Picton_New_Zealand.JPG",
                    -41.2833,
                    174.0000
                )
            ),
            WeatherModel(
                City(
                    "Westport",
                    "https://nzjane.com/wp-content/uploads/2021/09/westport-new-zealand.jpg",
                    -41.7393,
                    171.5692
                )
            ),
            WeatherModel(
                City(
                    "Christchurch",
                    "https://www.lovoirbeauty.com/wp-content/uploads/2023/07/3-1024x683.png",
                    -43.5333,
                    172.6333
                )
            ),
            WeatherModel(
                City(
                    "Queenstown",
                    "https://www.newzealand.com/assets/Tourism-NZ/Other/44ccbbaaa5/img-1541739164-9832-26853-p-ADB13BEC-ED2C-A382-17771639B530DD44-2544003__aWxvdmVrZWxseQo_CropResizeWzUwMCwzNzUsODAsImpwZyJd.jpg",
                    -45.031162,
                    168.662643
                )
            ),
            WeatherModel(
                City(
                    "Invercargill",
                    "https://www.newzealand.com/assets/Tourism-NZ/Southland/7cb55c61a0/img-1536905832-5015-28487-p-7BA1311A-DD95-DC93-8A3C7FD86A8B26EF-2544003__aWxvdmVrZWxseQo_FocalPointCropWzM1MiwxMDI0LDQ2LDUwLDc1LCJqcGciLDY1LDIuNV0.jpg",
                    -46.4199795,
                    168.3073077
                )
            ),
            WeatherModel(
                City(
                    "Dunedin",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/7/78/Dunedin_Railway_Station._%2814332788661%29.jpg/1200px-Dunedin_Railway_Station._%2814332788661%29.jpg",
                    -45.882551,
                    170.3006351
                )
            ),
            WeatherModel(
                City(
                    "Te Anau",
                    "https://www.newzealand.com/assets/Tourism-NZ/Fiordland/9a0dc4d063/img-1536090612-477-26261-p-6B2D5629-E541-0D54-77B505A1D2A6C8D0-2544003__aWxvdmVrZWxseQo_FocalPointCropWzM1MiwxMDI0LDMzLDQ5LDc1LCJwbmciLDY1LDIuNV0.png",
                    -45.416667,
                    167.716667
                )
            )
        )

        fun getNorthCities() = listOf(
            WeatherModel(
                City(
                    "Auckland",
                    "https://www.newzealand.com/assets/Tourism-NZ/Auckland/98618569ff/img-1536065871-6217-4403-p-10D1D0BD-B88E-AAB3-AE3F2E903EF65717-2544003__aWxvdmVrZWxseQo_CropResizeWzE5MDAsMTAwMCw3NSwianBnIl0.jpg",
                    -36.848461,
                    174.763336
                )
            ),
            WeatherModel(
                City(
                    "Wellington",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Wellington_city_with_Cable_Car.jpg/1200px-Wellington_city_with_Cable_Car.jpg",
                    -41.276825,
                    174.777969
                )
            ),
            WeatherModel(
                City(
                    "Whangarei",
                    "https://www.newzealand.com/assets/Operator-Database/e9101a375d/img-1536320500-6989-9871-p-F6FCF3BE-C67F-DCD8-E6B3157D67BE111A-2544003__aWxvdmVrZWxseQo_CropResizeWzE5MDAsMTAwMCw3NSwianBnIl0.jpg",
                    -35.7120022,
                    174.2036583
                )
            ),
            WeatherModel(
                City(
                    "Tauranga",
                    "https://p-airnz.com/cms/assets/Common-Assets/Destination-Images/new-zealand-water-city-mt-maunganui-2100x1395__ScaleMaxWidthWzkzMF0.jpg",
                    -37.683334,
                    176.166672
                )
            ),
            WeatherModel(
                City(
                    "Hamilton",
                    "https://upload.wikimedia.org/wikipedia/commons/6/68/Corner_of_Hood_Street%2C_Hamilton_New_Zealand.jpg",
                    -37.781528,
                    175.269363
                )
            ),
            WeatherModel(
                City(
                    "Taupo",
                    "https://www.tripsavvy.com/thmb/yUZhV9goMNJVHHJzPsTHx76BI54=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/lake-taupo-1064966832-3a6e1aa5957948b082218b9e73c384d6.jpg",
                    -38.6875,
                    176.0694
                )
            ),
            WeatherModel(
                City(
                    "Rotorua",
                    "https://upload.wikimedia.org/wikipedia/commons/5/51/Rotorua_museum.jpg",
                    -38.1387,
                    176.2452
                )
            ),
            WeatherModel(
                City(
                    "Gisborne",
                    "https://www.newzealand.com/assets/Gisborne__aWxvdmVrZWxseQo_FocalPointCropWzM1MiwxMDI0LDUwLDUwLDc1LCJqcGciLDY1LDIuNV0.jpg",
                    -38.662334,
                    178.017654
                )
            ),
            WeatherModel(
                City(
                    "Napier",
                    "https://upload.wikimedia.org/wikipedia/commons/5/53/Napier_Art_Deco%2C_New_Zealand_%286567969%29.jpg",
                    -39.4793965,
                    176.7863122
                )
            ),
            WeatherModel(
                City(
                    "Palmerston North",
                    "https://www.newzealand.com/assets/Tourism-NZ/Manawatu/The-Square-Palmerston-North-ManawatuNZ__aWxvdmVrZWxseQo_FocalPointCropWzM1MiwxMDI0LDUwLDUwLDc1LCJqcGciLDY1LDIuNV0.co.nz.jpg",
                    -40.3564,
                    175.6111
                )
            ),
            WeatherModel(
                City(
                    "Masterton",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Masterton_02.JPG/1200px-Masterton_02.JPG",
                    -40.9597,
                    175.6575
                )
            ),
            WeatherModel(
                City(
                    "New Plymouth",
                    "https://upload.wikimedia.org/wikipedia/commons/c/c1/New-plymouth-city-skyline-npdc.jpg",
                    -39.055626,
                    174.075226
                )
            )
        )
    }
}

