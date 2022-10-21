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
        //primeiro acesso
        primeiroAcesso()
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_login) {
            login()
        }
    }

    fun login(){
        val usuario = binding.editUser.text.toString()
        val senha = binding.editPassword.text.toString()
        val securityPreferencesUsuario = SecurityPreferences(this).getString("usuarioPadrao")
        val securityPreferencesSenha = SecurityPreferences(this).getString("senhaPadrao")
        if (usuario == securityPreferencesUsuario && senha == securityPreferencesSenha) {
            SecurityPreferences(this).storeString("username", usuario)
            Toast.makeText(this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Welcome::class.java)
            intent.putExtra("name", usuario)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Usuário ou senha incorretos!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun verificaSePossuiLogin() {
        val userAdmin = SecurityPreferences(this).getString("userAdmin")
        val userSenha = SecurityPreferences(this).getString("senhaAdmin")
        if (userSenha != "") {
            val intent = Intent(this, Welcome::class.java)
            intent.putExtra("userAdmin", userAdmin)
            startActivity(intent)
        }
    }
    private fun primeiroAcesso() {
        val userAdmin = SecurityPreferences(this).getString("userAdmin")
        val senhaAdmin = SecurityPreferences(this).getString("senhaAdmin")
        if ( senhaAdmin == "" && userAdmin == "") {
            val intent = Intent(this, DefineSenha::class.java)
            intent.putExtra("userAdmin", userAdmin)
            startActivity(intent)
        } else {
            verificaSePossuiLogin()
        }
    }
}

