package com.example.checklistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.room.Room
import com.example.checklistapp.databinding.ActivityRealizaCheckListBinding

class RealizaCheckList : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityRealizaCheckListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRealizaCheckListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //remove action bar
        supportActionBar!!.hide()
        // pega id da tela anterior
        val id = intent.getSerializableExtra("id")
        //mostra o id
        Toast.makeText(this, "${id}", Toast.LENGTH_SHORT).show()

        val db = Room.databaseBuilder(
            this,
            CheckListDatabase::class.java,
            "CheckListDatabase1.db"
        ).allowMainThreadQueries().build()

        val checkListDao = db.CheckListDao()
        checkListDao.atualizaChecklist( id.toString(), true )
        //update do status
        //atualizaCheckList(id)

    
    }

    override fun onClick(v: View) {

    }
    //atualiza checkList
    fun atualizaCheckList(){

        
        val db = Room.databaseBuilder(
            this,
            CheckListDatabase::class.java,
            "CheckListDatabase1.db"
        ).allowMainThreadQueries().build()

        val checkListDao = db.CheckListDao()
        //checkListDao.updateChecklist(id)
    }
    

}