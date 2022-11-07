package com.example.checklistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        if (definition != null) {
            val db = Room.databaseBuilder(
                this,
                CheckListDatabase::class.java,
                "CheckListDatabase1.db"
            ).allowMainThreadQueries().build()

            val checkListDao = db.CheckListDao()
            checkListDao.buscaChecklist()
            val checkLists = checkListDao.buscaChecklist()
            binding.recyclerChecklist.adapter = CheckListAdapter(checkLists as ArrayList<CheckList>, this)
            binding.recyclerChecklist.layoutManager = LinearLayoutManager(this)

        } else if (definition == "all"){
            val db = Room.databaseBuilder(
                this,
                CheckListDatabase::class.java,
                "CheckListDatabase1.db"
            ).allowMainThreadQueries().build()
            val checkListDao = db.CheckListDao()
            val checkLists = checkListDao.buscaChecklist()
            binding.recyclerChecklist.adapter = CheckListAdapter(checkLists as ArrayList<CheckList>, this)
            binding.recyclerChecklist.layoutManager = LinearLayoutManager(this)

        } else if (definition == "pendente"){
            val db = Room.databaseBuilder(
                this,
                CheckListDatabase::class.java,
                "CheckListDatabase1.db"
            ).allowMainThreadQueries().build()

            val checkListDao = db.CheckListDao()

            val checkLists = checkListDao.buscaChecklistPorStatus("pendente")
            binding.recyclerChecklist.adapter = CheckListAdapter(checkLists as ArrayList<CheckList>, this)
            binding.recyclerChecklist.layoutManager = LinearLayoutManager(this)
        }
    }


}