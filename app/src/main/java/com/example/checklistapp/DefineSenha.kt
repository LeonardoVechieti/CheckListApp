package com.example.checklistapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.checklistapp.databinding.ActivityDefineSenhaBinding

class DefineSenha : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityDefineSenhaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDefineSenhaBinding.inflate(layoutInflater)
        binding.buttonDefineSenha.setOnClickListener(this)
        setContentView(binding.root)

    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_define_senha){
            defineSenha()
        }
    }
    fun defineSenha(){
        val senha = binding.editDefineSenha.text.toString()
        val confirmaSenha = binding.editDefineConfirmaSenha.text.toString()
        if(senha == confirmaSenha){
            val securityPreferences = SecurityPreferences(this)
            securityPreferences.storeString("senhaAdmin", senha)
            finish()
            Toast.makeText(this, "Senha atualizada com sucesso!", Toast.LENGTH_SHORT).show()
            //redirect to welcome
            val intent = Intent(this, DefineUsuarioPadrao::class.java)
            intent.putExtra("senhaAdmin", senha)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Senhas não conferem!", Toast.LENGTH_SHORT).show()
        }
    }

}