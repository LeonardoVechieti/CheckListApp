package com.example.checklistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.checklistapp.databinding.ActivityWelcomeBinding

class Welcome : AppCompatActivity() {
    lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        supportActionBar!!.hide()
        setContentView(binding.root)
        setContentView(R.layout.activity_welcome)
    }


}