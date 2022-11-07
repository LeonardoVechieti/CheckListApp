package com.example.checklistapp


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.checklistapp.databinding.ActivityCreateNewChecListBinding
import java.text.SimpleDateFormat
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

        //pega data atual
        val formataData = SimpleDateFormat("dd/MM/yyyy")
        val data = Date()
        val dataAtualFormatada = formataData.format(data)


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
            checkListDao.insereChecklist(CheckList( placa, nomeMotorista, "pendente" , dataAtualFormatada,  false))
            Toast.makeText(this, "Criado com sucesso!", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            binding.textPlaca.error = "Preencha a placa"
            binding.textNomeMotorista.error = "Preencha o nome do motorista"
        }



    }
}