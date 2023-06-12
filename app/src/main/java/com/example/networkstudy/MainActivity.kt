package com.example.networkstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.networkstudy.databinding.ActivityMainBinding
import com.example.networkstudy.retrofit.RetrofitManager
import com.example.networkstudy.utils.API

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        fetchAndDisplayWeatherForCity()

    }

    private fun fetchAndDisplayWeatherForCity() {
        RetrofitManager.instance.getWeathers(city = "seoul") {
            runOnUiThread {
                binding.city.text = it?.city?.name
//                val iconUrl = API.ICON_BASE_URL + it?.weather?.get(0)?.icon + ".png"
//
//                Glide.with(this@MainActivity)
//                    .load(iconUrl)
//                    .into(binding.weatherImage)
            }
        }
    }
}