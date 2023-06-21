package com.example.networkstudy.retrofit

import android.util.Log
import com.example.networkstudy.RealtimeArrivalList
import com.example.networkstudy.Root
import com.example.networkstudy.utils.API
import com.example.networkstudy.utils.Constants.TAG
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import java.net.URLEncoder

class RetrofitManager {
    companion object {
        val instance = RetrofitManager()
    }
    private val iRetrofit: IRetrofit? = RetrofitClient.getClient(API.BASE_URL)?.create(IRetrofit::class.java)

    fun getRealtimeSubwayPosition(station: String, completion: ( List<RealtimeArrivalList>?) -> Unit) {
        val call = iRetrofit?.getRealtimePosition(apiKey = API.KEY, station = station) ?: return

        call.enqueue(object : retrofit2.Callback<Root> {
            override fun onResponse(call: Call<Root>, response: Response<Root>) {
                Log.d(TAG, "RetrofitManager - onResponse() called / response : ${response.body()}")
                completion(response.body()?.realtimeArrivalList)
            }

            override fun onFailure(call: Call<Root>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - onFailure() called / : $t")
            }
        })
    }
}