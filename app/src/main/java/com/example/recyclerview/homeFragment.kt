package com.example.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.FragmentHomeBinding


class homeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<MyAdapter.Waifu>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home,container,false)

        val newRecyclerView : RecyclerView = view.findViewById(R.id.recyclerview)
        newRecyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = MyAdapter(getUserdata())
        newRecyclerView.adapter = adapter
        return view

    }

    private fun getUserdata() : List<MyAdapter.Waifu>{
        imageId = arrayOf(
            R.drawable.xp1,
            R.drawable.xp3,
            R.drawable.xp4,
            R.drawable.xp5,
            R.drawable.xp6,
            R.drawable.xp7,
            R.drawable.xp8
        )
//recyclerview
        heading = arrayOf(
            "Waifu Image 1",
            "Waifu Image 2",
            "Waifu Image 3",
            "Waifu Image 4",
            "Waifu Image 5",
            "Waifu Image 6",
            "Waifu Image 7"
        )

        return listOf(
            MyAdapter.Waifu(R.drawable.xp1, "Waifu 1"),
            MyAdapter.Waifu(R.drawable.xp3, "Waifu 2"),
            MyAdapter.Waifu(R.drawable.xp4, "Waifu 3"),
            MyAdapter.Waifu(R.drawable.xp5, "Waifu 4"),
            MyAdapter.Waifu(R.drawable.xp6, "Waifu 5"),
            MyAdapter.Waifu(R.drawable.xp7, "Waifu 6"),
            MyAdapter.Waifu(R.drawable.xp8, "Waifu 7"),

        )


    }

}