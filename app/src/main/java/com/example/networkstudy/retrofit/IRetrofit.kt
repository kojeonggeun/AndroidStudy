package com.example.networkstudy.retrofit

import com.example.networkstudy.Root
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IRetrofit {
    @GET("api/subway/{key}/json/realtimeStationArrival/0/10/{station}")
    fun getRealtimePosition(@Path("key") apiKey: String,
                            @Path("station") station: String): Call<Root>
}