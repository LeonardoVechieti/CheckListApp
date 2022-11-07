package com.example.checklistapp

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class CheckListAdapter(private var checklist: ArrayList<CheckList>, private var context: Context)
    : RecyclerView.Adapter<CheckListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val delete_button = itemView.findViewById<ImageView>(R.id.img_delete)
        val card_button = itemView.findViewById<ImageView>(R.id.cardItem)
        fun bind(checklist: CheckList) {
            itemView.findViewById<TextView>(R.id.txt_nome_motorista).text = checklist.nomeMotorista
            itemView.findViewById<TextView>(R.id.txt_placa).text = checklist.placa
            var status = checklist.status
            if(status == "conforme"){
                status = "Status: Conforme"
                itemView.findViewById<TextView>(R.id.txt_status).text = status
            }else if(status == "não conforme"){
                status = "Status: Não Conforme"
                itemView.findViewById<TextView>(R.id.txt_status).text = status
            }else if (status == "pendente"){
                status = "Status: Pendente"
                itemView.findViewById<TextView>(R.id.txt_status).text = status
            }
            itemView.findViewById<TextView>(R.id.txt_data).text = checklist.data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckListAdapter.ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_checklist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CheckListAdapter.ViewHolder, position: Int) {
        val checklist = this.checklist[position]
        holder.bind(checklist)
        holder.delete_button.setOnClickListener{
            AlertDialog.Builder(this.context)
                .setTitle("Deletar ${checklist.placa} ?")
                .setPositiveButton("Confirmar",{ _, _-> deleteItem(checklist) })
                .setNegativeButton(" Cancelar",{ _, _->})
                .show()
        }
        holder.card_button.setOnClickListener{
            val intent = android.content.Intent(context, RealizaCheckList::class.java)
            intent.putExtra("id", checklist.id)
            context.startActivity(intent)
            //Toast.makeText(context, "${checklist.id}", Toast.LENGTH_SHORT).show()

       }
    }
    fun deleteItem(item: CheckList){
        this.checklist.remove(item)
        var db = Room.databaseBuilder(
            context, CheckListDatabase::class.java,
            "CheckListDatabase1.db"
        ).allowMainThreadQueries().build()
        val dao = db.CheckListDao()
        dao.deleteChecklist(item)
        Toast.makeText(context, "Removida com sucesso",
            Toast.LENGTH_SHORT).show()
        this.notifyDataSetChanged()
    }

    // fun update checkList
    fun atualizaCheckList(checklist: CheckList){
        var db = Room.databaseBuilder(
            context, CheckListDatabase::class.java,
            "CheckListDatabase1.db"
        ).allowMainThreadQueries().build()
        val dao = db.CheckListDao()
        dao.updateChecklist(checklist)
        Toast.makeText(context, "Atualizado com sucesso",
            Toast.LENGTH_SHORT).show()
        this.notifyDataSetChanged()
    }



    override fun getItemCount(): Int {
        return this.checklist.size
    }
}


