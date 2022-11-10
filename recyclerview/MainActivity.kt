package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = ChanAdapter()
    private var editLauncher: ActivityResultLauncher<Intent>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                adapter.addChan(it.data?.getSerializableExtra("тян") as Girls)
            }
        }
    }
    private fun init(){
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(this@MainActivity) /// GridLayoutManager(this@MainActivity,3)
            rcView.adapter = adapter
            addbut.setOnClickListener{
                editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))

            }

        }
    }
}