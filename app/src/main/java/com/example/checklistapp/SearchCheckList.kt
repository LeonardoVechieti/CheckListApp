package com.example.checklistapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.checklistapp.databinding.ActivitySearchCheckListBinding

class SearchCheckList : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivitySearchCheckListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchCheckListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.menuList.setOnClickListener(this)
        binding.menuNew.setOnClickListener(this)
        binding.menuSearch.setOnClickListener(this)
        binding.buttonNew.setOnClickListener(this)
        binding.buttonPendentes.setOnClickListener(this)
        binding.buttonConformes.setOnClickListener(this)
        binding.buttonNaoConformes.setOnClickListener(this)
        binding.buttonPesquisar.setOnClickListener(this)
        //remove action bar
        supportActionBar!!.hide()
    }

    override fun onClick(view: View) {
        if (view.id == R.id.menu_list) {
            val intent = Intent(this, ListAllCheckList::class.java)
            //passa a definicao
            intent.putExtra("definition", "all")
            startActivity(intent)
        }
        if (view.id == R.id.menu_new || view.id == R.id.floatingActionButton) {
            val intent = Intent(this, CreateNewChecList::class.java)
            startActivity(intent)
        }
        if(view.id == R.id.menu_search){
            //val intent = Intent(this, SearchCheckList::class.java)
            //startActivity(intent)
            Toast.makeText(this, "Você já está na tela selecionada!", Toast.LENGTH_SHORT).show()
        }
        if(view.id == R.id.button_conformes){
            //Toast.makeText(this, "CliqueiC", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ListAllCheckList::class.java)
            //passa a definicao
            intent.putExtra("definition", "conforme")
            startActivity(intent)
        }
        if(view.id == R.id.button_nao_conformes){
            //Toast.makeText(this, "CliqueiNC", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ListAllCheckList::class.java)
            //passa a definicao
            intent.putExtra("definition", "naoConforme")
            startActivity(intent)
        }
        if(view.id == R.id.button_pendentes){
            //Toast.makeText(this, "CliqueiPende", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ListAllCheckList::class.java)
            //passa a definicao
            intent.putExtra("definition", "pendente")
            startActivity(intent)
        }
        if (view.id == R.id.button_pesquisar) {
            if(binding.editTextPesquisa.text.toString().isNotEmpty()){
                val intent = Intent(this, ListAllCheckList::class.java)
                //passa a definicao
                intent.putExtra("definition", "search")
                intent.putExtra("search", binding.editTextPesquisa.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this, "Digite a placa para pesquisar!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}