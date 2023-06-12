package com.example.networkstudy.retrofit

import com.example.networkstudy.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IRetrofit {
    @GET("forecast")
    fun getWeathers(@Query("q") city: String,
                    @Query("appid") apiKey: String): Call<WeatherResponse>

}