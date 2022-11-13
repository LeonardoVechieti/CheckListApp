package com.example.checklistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.checklistapp.databinding.ActivityListAllCheckListBinding

class ListAllCheckList : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityListAllCheckListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListAllCheckListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //remove action bar
        supportActionBar!!.hide()

        val db = Room.databaseBuilder(
            this,
            CheckListDatabase::class.java,
            "CheckListDatabase1.db"
        ).allowMainThreadQueries().build()

    }

    override fun onClick(v: View?) {

    }

    override fun onResume() {
        super.onResume()
        //pega definicao
        val definition = intent.getStringExtra("definition")
        val search = intent.getStringExtra("search")
        //Toast.makeText(this, definition, Toast.LENGTH_SHORT).show()
        //pega o banco de dados
        when (definition) {
            null -> {
                val db = Room.databaseBuilder(
                    this,
                    CheckListDatabase::class.java,
                    "CheckListDatabase1.db"
                ).allowMainThreadQueries().build()

                val checkListDao = db.CheckListDao()
                checkListDao.buscaChecklist()
                val checkLists = checkListDao.buscaChecklist()
                if(checkLists.isNotEmpty()){
                    binding.recyclerChecklist.adapter = CheckListAdapter(checkLists as ArrayList<CheckList>, this)
                    binding.recyclerChecklist.layoutManager = LinearLayoutManager(this)
                } else {
                    Toast.makeText(this, "Não há checklist cadastrados", Toast.LENGTH_SHORT).show()
                    //volta a tela anterior
                    finish()
                }


            }
            "all" -> {
                val db = Room.databaseBuilder(
                    this,
                    CheckListDatabase::class.java,
                    "CheckListDatabase1.db"
                ).allowMainThreadQueries().build()
                val checkListDao = db.CheckListDao()
                val checkLists = checkListDao.buscaChecklist()
                if(checkLists.isNotEmpty()){
                    binding.recyclerChecklist.adapter = CheckListAdapter(checkLists as ArrayList<CheckList>, this)
                    binding.recyclerChecklist.layoutManager = LinearLayoutManager(this)
                } else {
                    Toast.makeText(this, "Não há checklist cadastrados", Toast.LENGTH_SHORT).show()
                    //volta a tela anterior
                    finish()
                }

            }
            "pendente" -> {
                val db = Room.databaseBuilder(
                    this,
                    CheckListDatabase::class.java,
                    "CheckListDatabase1.db"
                ).allowMainThreadQueries().build()

                val checkListDao = db.CheckListDao()

                val checkLists = checkListDao.buscaChecklistPorStatus("pendente")
                if(checkLists.isNotEmpty()){
                    binding.recyclerChecklist.adapter = CheckListAdapter(checkLists as ArrayList<CheckList>, this)
                    binding.recyclerChecklist.layoutManager = LinearLayoutManager(this)
                } else {
                    Toast.makeText(this, "Não há checklist cadastrados", Toast.LENGTH_SHORT).show()
                    //volta a tela anterior
                    finish()
                }
            }
            "conforme" -> {
                val db = Room.databaseBuilder(
                    this,
                    CheckListDatabase::class.java,
                    "CheckListDatabase1.db"
                ).allowMainThreadQueries().build()

                val checkListDao = db.CheckListDao()

                val checkLists = checkListDao.buscaChecklistPorStatus("conforme")
                if(checkLists.isNotEmpty()){
                    binding.recyclerChecklist.adapter = CheckListAdapter(checkLists as ArrayList<CheckList>, this)
                    binding.recyclerChecklist.layoutManager = LinearLayoutManager(this)
                } else {
                    Toast.makeText(this, "Não há checklist cadastrados", Toast.LENGTH_SHORT).show()
                    //volta a tela anterior
                    finish()
                }
            }
            "naoConforme" -> {
                val db = Room.databaseBuilder(
                    this,
                    CheckListDatabase::class.java,
                    "CheckListDatabase1.db"
                ).allowMainThreadQueries().build()

                val checkListDao = db.CheckListDao()

                val checkLists = checkListDao.buscaChecklistPorStatus("não conforme")
                if(checkLists.isNotEmpty()){
                    binding.recyclerChecklist.adapter = CheckListAdapter(checkLists as ArrayList<CheckList>, this)
                    binding.recyclerChecklist.layoutManager = LinearLayoutManager(this)
                } else {
                    Toast.makeText(this, "Não há checklist cadastrados", Toast.LENGTH_SHORT).show()
                    //volta a tela anterior
                    finish()
                }
            }
            "search" -> {
                val db = Room.databaseBuilder(
                    this,
                    CheckListDatabase::class.java,
                    "CheckListDatabase1.db"
                ).allowMainThreadQueries().build()

                val checkListDao = db.CheckListDao()

                val checkLists = checkListDao.buscaChecklistPorPlaca(search.toString().toUpperCase())
                if(checkLists.isNotEmpty()){
                    binding.recyclerChecklist.adapter = CheckListAdapter(checkLists as ArrayList<CheckList>, this)
                    binding.recyclerChecklist.layoutManager = LinearLayoutManager(this)
                } else {
                    Toast.makeText(this, "Não foi possível encontrar resultados", Toast.LENGTH_SHORT).show()
                    //volta a tela anterior
                    finish()
                }
            }
        }
    }


}