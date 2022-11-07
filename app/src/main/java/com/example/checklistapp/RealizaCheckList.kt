package com.example.checklistapp

import android.app.AlertDialog
import android.content.Context
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
        var context: Context
        binding = ActivityRealizaCheckListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonConforme.setOnClickListener(this)
        binding.buttonNaoConforme.setOnClickListener(this)
        //remove action bar
        supportActionBar!!.hide()

        // pega id da tela anterior
        val id = intent.getSerializableExtra("id")

        //mostra o id
        Toast.makeText(this, "${id}", Toast.LENGTH_SHORT).show()

        // atualiza tela para o checkList selecionado
        atualizaCheckList(id.toString())

    }

    override fun onBackPressed() {
        //super.onBackPressed()
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Deseja salvar as modificações?")
        builder.setPositiveButton("Sim"){dialog, which ->
            SalvarModificacoes()
            finish()
        }
        builder.setNegativeButton("Não"){dialog, which ->
            finish()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    override fun onClick(v: View) {
        if (v.id == binding.buttonConforme.id){
            Conforme()
        }
        if (v.id == binding.buttonNaoConforme.id){
            NaoConforme()
        }
    }
    //atualiza checkList
    fun atualizaCheckList(id: String) {

        val db = Room.databaseBuilder(
            this,
            CheckListDatabase::class.java,
            "CheckListDatabase1.db"
        ).allowMainThreadQueries().build()

        val checkListDao = db.CheckListDao()
        val checklist = checkListDao.buscaChecklistPorId(id)

        binding.item1.isChecked = checklist.item1 == true
        binding.item2.isChecked = checklist.item2 == true
        binding.item3.isChecked = checklist.item3 == true
        binding.item4.isChecked = checklist.item4 == true
        binding.item5.isChecked = checklist.item5 == true
        binding.item6.isChecked = checklist.item6 == true
        binding.item7.isChecked = checklist.item7 == true
        binding.item8.isChecked = checklist.item8 == true
        binding.item9.isChecked = checklist.item9 == true
        binding.item10.isChecked = checklist.item10 == true
    }


    fun Conforme() {
        if(!binding.item1.isChecked || !binding.item2.isChecked || !binding.item3.isChecked || !binding.item4.isChecked || !binding.item5.isChecked || !binding.item6.isChecked || !binding.item7.isChecked || !binding.item8.isChecked || !binding.item9.isChecked || !binding.item10.isChecked){
            Toast.makeText(this, "Há itens que ainda precisam ser verificados", Toast.LENGTH_SHORT).show()
        }else{
            // pega id da tela anterior
            val id = intent.getSerializableExtra("id")
            val db = Room.databaseBuilder(
                this,
                CheckListDatabase::class.java,
                "CheckListDatabase1.db"
            ).allowMainThreadQueries().build()

            val checkListDao = db.CheckListDao()
            val checklist = checkListDao.buscaChecklistPorId(id.toString())
            AlertDialog.Builder(this)
                .setTitle("Finalizar: Conforme")
                .setMessage("Tem certeza que deseja finalizar a checagem da placa ${checklist.placa} ?")
                .setPositiveButton("Confirmar",{ _, _-> finalizaCheckListConforme()})
                .setNegativeButton(" Cancelar",{ _, _->})
                .show()

        }
    }
    fun NaoConforme() {
        // pega id da tela anterior
        val id = intent.getSerializableExtra("id")
        val db = Room.databaseBuilder(
            this,
            CheckListDatabase::class.java,
            "CheckListDatabase1.db"
        ).allowMainThreadQueries().build()

        val checkListDao = db.CheckListDao()
        val checklist = checkListDao.buscaChecklistPorId(id.toString())
        AlertDialog.Builder(this)
            .setTitle("Finalizar: Não Conforme")
            .setMessage("Tem certeza que deseja finalizar a checagem da placa ${checklist.placa} ?")
            .setPositiveButton("Confirmar",{ _, _-> finalizaCheckListNaoConforme()})
            .setNegativeButton(" Cancelar",{ _, _->})
            .show()
    }

    fun finalizaCheckListConforme(){
        // pega id da tela anterior
        val id = intent.getSerializableExtra("id")
        val db = Room.databaseBuilder(
            this,
            CheckListDatabase::class.java,
            "CheckListDatabase1.db"
        ).allowMainThreadQueries().build()

        val checkListDao = db.CheckListDao()
        checkListDao.atualizaChecklist( item1 = true, item2 = true, item3 = true, item4 = true, item5 = true, item6 = true, item7 = true, item8 = true, item9 = true, item10 = true, id = id.toString() )
        checkListDao.atualizaStatus( id.toString(), "conforme" )
        finish()
    }
    fun finalizaCheckListNaoConforme(){
        // pega id da tela anterior
        val id = intent.getSerializableExtra("id")
        val db = Room.databaseBuilder(
            this,
            CheckListDatabase::class.java,
            "CheckListDatabase1.db"
        ).allowMainThreadQueries().build()

        val checkListDao = db.CheckListDao()
        checkListDao.atualizaChecklist( item1 = binding.item1.isChecked, item2 = binding.item2.isChecked, item3 = binding.item3.isChecked, item4 = binding.item4.isChecked, item5 = binding.item5.isChecked, item6 = binding.item6.isChecked, item7 = binding.item7.isChecked, item8 = binding.item8.isChecked, item9 = binding.item9.isChecked, item10 = binding.item10.isChecked, id = id.toString() )
        checkListDao.atualizaStatus( id.toString(), "não conforme" )
        finish()
    }
    fun SalvarModificacoes(){
        // pega id da tela anterior
        val id = intent.getSerializableExtra("id")
        val db = Room.databaseBuilder(
            this,
            CheckListDatabase::class.java,
            "CheckListDatabase1.db"
        ).allowMainThreadQueries().build()

        val checkListDao = db.CheckListDao()
        checkListDao.atualizaChecklist( item1 = binding.item1.isChecked, item2 = binding.item2.isChecked, item3 = binding.item3.isChecked, item4 = binding.item4.isChecked, item5 = binding.item5.isChecked, item6 = binding.item6.isChecked, item7 = binding.item7.isChecked, item8 = binding.item8.isChecked, item9 = binding.item9.isChecked, item10 = binding.item10.isChecked, id = id.toString() )
        if (binding.item1.isChecked && binding.item2.isChecked && binding.item3.isChecked && binding.item4.isChecked && binding.item5.isChecked && binding.item6.isChecked && binding.item7.isChecked && binding.item8.isChecked && binding.item9.isChecked && binding.item10.isChecked){
            //checkListDao.atualizaStatus( id.toString(), "conforme" )
        }else{
            checkListDao.atualizaStatus( id.toString(), "não conforme" )
            Toast.makeText(this, "O status foi alterado para 'Não Conforme'", Toast.LENGTH_SHORT).show()

        }
    }



}