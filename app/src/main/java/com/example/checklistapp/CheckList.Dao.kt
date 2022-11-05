package com.example.checklistapp
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface CheckListDao {

    @Query("SELECT * FROM CheckList")
    fun buscaChecklist(): List<CheckList>

    @Insert
    fun insereChecklist(task: CheckList)

    @Delete
    fun deleteChecklist(task: CheckList)

    @Update
    fun updateChecklist(task: CheckList)

    @Query ("UPDATE CheckList SET finalizado = :finalizado WHERE id = :id")
    fun atualizaChecklist(id: String, finalizado: Boolean)
}