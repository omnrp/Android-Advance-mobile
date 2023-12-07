package com.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Waifu>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.in    flate(layoutInflater)
        setContentView(binding.root)

        val fragment = homeFragment.newInstance("test1", "test2")
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(menuItemSelected)
        addFragment(fragment)

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

        newRecyclerView = binding.recyclerview
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Waifu>()
        getUserdata()
    }

    private fun getUserdata() {
        for (i in imageId.indices) {
            val waifu = Waifu(imageId[i], heading[i])
            newArrayList.add(waifu)
        }

        newRecyclerView.adapter = MyAdapter(newArrayList)
    }

    private val menuItemSelected =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_home -> {
                    val fragment = homeFragment.newInstance("test1", "test2")
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.item_message -> {
                    val fragment = MessageFragment.newInstance("test1", "test2")
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.item_nontification -> {
                    val fragment = NontificationFragment.newInstance("test1", "test2")
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.item_profile -> {
                    val fragment = ProfileFragment.newInstance("test1", "test2")
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                com.google.android.material.R.anim.design_bottom_sheet_slide_in,
                com.google.android.material.R.anim.design_bottom_sheet_slide_out
            )
            .replace(R.id.content, fragment, fragment.javaClass.simpleName)
            .commit()
    }
}
