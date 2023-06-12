package com.example.networkstudy.retrofit

import android.util.Log
import com.example.networkstudy.utils.Constants.TAG
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
//    이것도 가능
//    private lateinit var retrofitClient: Retrofit
    private var retrofitClient: Retrofit? = null

    fun getClient(baseUrl: String): Retrofit? {
        Log.d(TAG, "RetrofitClient - getClient() called $baseUrl")
        if (retrofitClient == null) {
            retrofitClient = Retrofit.Builder()
                                     .baseUrl(baseUrl)
                                     .addConverterFactory(GsonConverterFactory.create())
                                     .build()
        }
        return retrofitClient
    }
}