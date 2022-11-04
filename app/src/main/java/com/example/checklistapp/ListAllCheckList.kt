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

        //val checkListDao = db.CheckListDao()
        //checkListDao.insereChecklist(CheckList( "ABC1234", "Leonardo", false , "01/01/2021",  true))
    }

    override fun onClick(v: View?) {

    }

    override fun onResume() {
        super.onResume()
        val db = Room.databaseBuilder(
            this,
            CheckListDatabase::class.java,
            "CheckListDatabase1.db"
        ).allowMainThreadQueries().build()

        val checkListDao = db.CheckListDao()

        val checkLists = checkListDao.buscaChecklist()
        binding.recyclerChecklist.adapter = CheckListAdapter(checkLists as ArrayList<CheckList>, this)
        binding.recyclerChecklist.layoutManager = LinearLayoutManager(this)
    }


}