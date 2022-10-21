package com.example.checklistapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.checklistapp.databinding.ActivityWelcomeBinding

class Welcome : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //remove action bar
        supportActionBar!!.hide()

        //busca o nome do usuário
        verifyUserName()

        //setContentView(R.layout.activity_welcome)
    }

    override fun onClick(view: View) {
        TODO("Not yet implemented")
    }

    @SuppressLint("SetTextI18n")
    private fun verifyUserName() {
        val username =  SecurityPreferences(this).getString("usuarioPadrao")
        binding.nomeUsuario.text = "Olá, $username!"
    }


}