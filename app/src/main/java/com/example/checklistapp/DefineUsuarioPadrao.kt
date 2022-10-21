package com.example.checklistapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.checklistapp.databinding.ActivityDefineUsuarioPadraoBinding

class DefineUsuarioPadrao : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityDefineUsuarioPadraoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDefineUsuarioPadraoBinding.inflate(layoutInflater)
        binding.buttonDefineUsuarioPadrao.setOnClickListener(this)
        setContentView(binding.root)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_define_usuario_padrao){
            defineUsuarioPadrao()
        }
    }
    private fun defineUsuarioPadrao(){
        val nomeUsuarioPadrao = binding.editDefineUsuarioPadrao.text.toString()
        val senhaUsuarioPadrao = binding.editDefineSenha.text.toString()
        val confirmaSenhaUsuarioPadrao = binding.editDefineConfirmaSenha.text.toString()
        if(senhaUsuarioPadrao == confirmaSenhaUsuarioPadrao && nomeUsuarioPadrao!= ""){
            val securityPreferences = SecurityPreferences(this)
            securityPreferences.storeString("usuarioPadrao", nomeUsuarioPadrao)
            securityPreferences.storeString("senhaPadrao", senhaUsuarioPadrao)
            finish()
            Toast.makeText(this, "Usuário padrão atualizado com sucesso!", Toast.LENGTH_SHORT).show()
            //redirect to welcome
            val intent = Intent(this, Welcome::class.java)
            intent.putExtra("nomeUsuarioPadrao", nomeUsuarioPadrao)

            startActivity(intent)
        }else{

        }
    }
}