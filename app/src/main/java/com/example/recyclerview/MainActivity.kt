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


    //Recyclerview
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

            binding.bottomNavigationView.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.item_home -> {
                        addFragment(homeFragment())
                        true
                    }

                    R.id.item_message -> {
                        addFragment(MessageFragment())
                        true
                    }

                    R.id.item_nontification -> {
                        addFragment(NontificationFragment())
                        true
                    }

                    R.id.item_profile -> {
                        addFragment(ProfileFragment())
                        true
                    }

                    else -> false
                }
            }

    }

//navbar

//navbar
    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                com.google.android.material.R.anim.design_bottom_sheet_slide_in,
                com.google.android.material.R.anim.design_bottom_sheet_slide_out
            )
            .replace(R.id.tempatFragment, fragment, fragment.javaClass.simpleName)
            .commit()
    }
}
