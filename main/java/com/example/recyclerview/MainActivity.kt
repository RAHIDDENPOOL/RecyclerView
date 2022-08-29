package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = ChanAdapter()
    private val imageIdList = listOf(R.drawable.sberchan1,
        R.drawable.sberchan2,
        R.drawable.sberchan3,
        R.drawable.sberchan4,
        R.drawable.sberchan5,
        R.drawable.sberchan6,
        R.drawable.sberchan7,
    )
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    private fun init(){
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(this@MainActivity) /// GridLayoutManager(this@MainActivity,3)
            rcView.adapter = adapter
            addbut.setOnClickListener{
                if(index > 6) index = 0 // can change index if looking bad on layout
                val cuteChan = Girls(imageIdList[index], "Chan $index")
                adapter.addChan(cuteChan)
                index++
            }
        }
    }
}