package com.example.emjoyyourmeal

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var NavController : NavController = findNavController(R.id.fragmentContainerView)
        var bottomnav:BottomNavigationView = findViewById <BottomNavigationView>(R.id.bottomNavigationView)
        bottomnav.setupWithNavController(NavController)


    }
}