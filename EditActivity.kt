package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.recyclerview.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    private var indexImage = 0
    private var imageId = R.drawable.sberchan1
    private val imageIdList = listOf(
        R.drawable.sberchan1,
        R.drawable.sberchan2,
        R.drawable.sberchan3,
        R.drawable.sberchan4,
        R.drawable.sberchan5,
        R.drawable.sberchan6,
        R.drawable.sberchan7,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }
    private fun initButtons() = with(binding){
        bChoose.setOnClickListener{
            indexImage++
            if(indexImage > imageIdList.size - 1) indexImage = 0
            Log.d("CheckCorrectSize", "Index: $indexImage")
            imageId = imageIdList[indexImage]
            imageView.setImageResource(imageId)
        }
        bDone.setOnClickListener {
            val chan = Girls(imageId, EdTittle.text.toString(), EdDescription.text.toString())
            val editIntent = Intent().apply{
                putExtra("тян", chan)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}