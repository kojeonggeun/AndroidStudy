package com.example.networkstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.networkstudy.databinding.ActivityMainBinding
import com.example.networkstudy.retrofit.RetrofitManager
import com.example.networkstudy.utils.API

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchRealTimeSubwayInfo()

    }

    private fun fetchRealTimeSubwayInfo() {
        RetrofitManager.instance.getRealtimeSubwayPosition(station = "부천") {
            runOnUiThread {
                it?.let { realtimeArrivalList ->
                    val adapter = SubwayAdapter(realtimeArrivalList)
                    recyclerView.adapter = adapter
                }
            }
        }
    }
}