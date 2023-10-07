package com.example.kukathonapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavi = findViewById<BottomNavigationView>(R.id.bottom_navi)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        bottomNavi.setupWithNavController(navController)

        bottomNavi.setOnItemSelectedListener {item->
            when(item.itemId){
                R.id.home-> {
                    navController.navigate(R.id.oneFragment)
                true}
                R.id.item2->{
                    navController.navigate(R.id.twoFragment)
                    true}
                R.id.item3->{
                    navController.navigate(R.id.threeFragment)
                    true}

                else->false
            }
        }
    }
}