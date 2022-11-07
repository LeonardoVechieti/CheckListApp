package com.example.checklistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.checklistapp.databinding.ActivitySearchCheckListBinding

class SearchCheckList : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivitySearchCheckListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchCheckListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onClick(v: View) {

    }
}