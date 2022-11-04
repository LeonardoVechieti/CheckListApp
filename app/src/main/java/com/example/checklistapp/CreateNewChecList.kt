package com.example.checklistapp


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.checklistapp.databinding.ActivityCreateNewChecListBinding
import java.util.*


class CreateNewChecList : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityCreateNewChecListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateNewChecListBinding.inflate(layoutInflater)
        binding.buttonAddNewCheckList.setOnClickListener(this)
        setContentView(binding.root)

        //remove action bar
        supportActionBar!!.hide()

    }

    override fun onClick(v: View) {
        if(v.id == R.id.button_add_new_check_list){
            addNewCheckList()

        }
    }

    fun addNewCheckList(){

        //obtem data atual
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val dataAtual = "$day/$month/$year"
        //formata data atual
        val dataAtualFormatada = dataAtual.replace("/0", "/").replace("/0", "/")


        val placa = binding.textPlaca.text.toString()
        val nomeMotorista = binding.textNomeMotorista.text.toString()
        //Toast.makeText(this, "Cliquei", Toast.LENGTH_SHORT).show()

        if( placa.isNotEmpty() && nomeMotorista.isNotEmpty() ){
            val db = Room.databaseBuilder(
                this,
                CheckListDatabase::class.java,
                "CheckListDatabase1.db"
            ).allowMainThreadQueries().build()

            val checkListDao = db.CheckListDao()
            checkListDao.insereChecklist(CheckList( placa, nomeMotorista, false , dataAtualFormatada,  true))
            Toast.makeText(this, "Criado com sucesso!", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            binding.textPlaca.error = "Preencha a placa"
            binding.textNomeMotorista.error = "Preencha o nome do motorista"
        }



    }
}