package com.example.ktrv

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ktrv.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var adapter = Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

        adapter.add(DataClass(1, "1"))
        adapter.add(DataClass(2, "2"))
        adapter.add(DataClass(3, "3"))
        adapter.add(DataClass(4, "4"))

    }

    private fun init() = with(binding) {
        recyclerView.layoutManager = LinearLayoutManager(
            this@MainActivity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        recyclerView.adapter = adapter
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
        snapHelper.onFling(100, 100)

//        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//
//                val myLayoutManager: LinearLayoutManager = recyclerView.layoutManager as LinearLayoutManager
//                val scrollPosition = myLayoutManager.findLastVisibleItemPosition()
//
//                Log.e("oiafknmoe", scrollPosition.toString())
//            }
//
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//
//
//            }
//
//
//
//        })

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val myLayoutManager: LinearLayoutManager = recyclerView.layoutManager as LinearLayoutManager
                val scrollPosition = myLayoutManager.findLastCompletelyVisibleItemPosition()
//
                Log.e("oiafknmoe", scrollPosition.toString())
            }
        })

    }

}