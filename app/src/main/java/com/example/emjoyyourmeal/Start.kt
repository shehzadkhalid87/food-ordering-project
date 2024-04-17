package com.example.emjoyyourmeal

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.emjoyyourmeal.databinding.ActivityStartBinding

class Start : AppCompatActivity() {
    private  val binding: ActivityStartBinding by lazy{
        ActivityStartBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.nextbtn.setOnClickListener {
            val nextLogin = Intent(this, LoginActivity::class.java)
            startActivity(nextLogin)
        }
    }
}