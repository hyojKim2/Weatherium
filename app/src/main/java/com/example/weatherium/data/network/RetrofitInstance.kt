package com.example.weatherium.data.network


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Retrofit 객체 싱글톤 재사용
 */
object RetrofitInstance {

    private const val BASE_URL =
        "https://api.openweathermap.org/data/2.5/"

    val api: WeatherApi by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
            .create(WeatherApi::class.java)
    }
}

