package com.example.emjoyyourmeal

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.emjoyyourmeal.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private  val binding: ActivityLoginBinding by lazy{
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.loginbtn.setOnClickListener{
            val intent = Intent(this,SignUpScreen::class.java)
            startActivity(intent)
        }
        binding.donotbtn.setOnClickListener{
            val intent = Intent(this,SignUpScreen::class.java)
            startActivity(intent)
        }


    }
}