package com.example.weatherium.data.network

import com.example.weatherium.data.model.WeatherData
import retrofit2.http.GET
import retrofit2.http.Query

//Retrofit API 정의
/**
 * Retrofit언 어떤 주소로 요청을 보낼지 인터페이스로 정의함.
 */
interface WeatherApi {

    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): WeatherData
}