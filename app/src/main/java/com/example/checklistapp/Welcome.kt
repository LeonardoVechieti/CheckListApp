package com.example.checklistapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.checklistapp.databinding.ActivityWelcomeBinding

class Welcome : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        binding.menuList.setOnClickListener(this)
        binding.menuNew.setOnClickListener(this)
        binding.menuSearch.setOnClickListener(this)
        binding.buttonNewFloat.setOnClickListener(this)
        setContentView(binding.root)

        //remove action bar
        supportActionBar!!.hide()

        //busca o nome do usuário
        verifyUserName()

        //setContentView(R.layout.activity_welcome)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.menu_list) {
            val intent = Intent(this, ListAllCheckList::class.java)
            startActivity(intent)
        }
        if (view.id == R.id.menu_new || view.id == R.id.button_new_float) {
            val intent = Intent(this, CreateNewChecList::class.java)
            startActivity(intent)
        }
        if(view.id == R.id.menu_search){
            val intent = Intent(this, RealizaCheckList::class.java)
            startActivity(intent)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun verifyUserName() {
        val username =  SecurityPreferences(this).getString("usuarioPadrao")
        binding.nomeUsuario.text = "Olá, $username!"
    }


}