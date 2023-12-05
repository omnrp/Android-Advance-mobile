package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Waifu>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.xp1,
            R.drawable.xp3,
            R.drawable.xp4,
            R.drawable.xp5,
            R.drawable.xp6,
            R.drawable.xp7,
            R.drawable.xp8

        )

        heading = arrayOf(
            "Waifu Image 1",
            "Waifu Image 2",
            "Waifu Image 3",
            "Waifu Image 4",
            "Waifu Image 5",
            "Waifu Image 6",
            "Waifu Image 7"

        )

        newRecyclerView = findViewById(R.id.recyclerview)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Waifu>()
        getUserdata()

    }

    private fun getUserdata() {

        for (i in imageId.indices){

            val waifu = Waifu(imageId[i],heading[i])
            newArrayList.add(waifu)
        }

        newRecyclerView.adapter = MyAdapter(newArrayList)


    }
}