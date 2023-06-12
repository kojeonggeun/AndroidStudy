package com.example.networkstudy.retrofit

import android.util.Log
import com.example.networkstudy.WeatherResponse
import com.example.networkstudy.utils.API
import com.example.networkstudy.utils.Constants.TAG
import retrofit2.Call
import retrofit2.Response

class RetrofitManager {
    companion object {
        val instance = RetrofitManager()
    }
    private val iRetrofit: IRetrofit? = RetrofitClient.getClient(API.BASE_URL)?.create(IRetrofit::class.java)

    fun getWeathers(city: String, completion: (WeatherResponse?) -> Unit) {
        val call = iRetrofit?.getWeathers(city = city, apiKey = API.KEY) ?: return

        call.enqueue(object : retrofit2.Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                Log.d(TAG, "RetrofitManager - onResponse() called / response : ${response.body()}")
                completion(response.body())
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - onFailure() called / : $t")
            }
        })
    }
}