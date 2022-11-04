package com.example.checklistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.checklistapp.databinding.ActivityRealizaCheckListBinding

class RealizaCheckList : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityRealizaCheckListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRealizaCheckListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //remove action bar
        supportActionBar!!.hide()
    }

    override fun onClick(v: View) {

    }
}