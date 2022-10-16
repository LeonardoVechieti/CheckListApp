package com.example.checklistapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import com.example.checklistapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), OnClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.buttonLogin.setOnClickListener(this)
        binding.editUser.setOnClickListener(this)
        binding.editPassword.setOnClickListener(this)
        supportActionBar!!.hide()
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_login) {
            val usuario = binding.editUser.text.toString()
            val senha = binding.editPassword.text.toString()
            if (usuario == "Operador" && senha == "op") {
                Toast.makeText(this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Welcome::class.java)
                intent.putExtra("name", usuario)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuário ou senha incorretos!", Toast.LENGTH_SHORT).show()
            }
        }
    }


}