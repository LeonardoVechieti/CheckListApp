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

    @Query ("UPDATE CheckList SET item1 = :item1, item2 = :item2, item3 = :item3, item4 = :item4, item5 = :item5, item6 = :item6, item7 = :item7, item8 = :item8, item9 = :item9, item10 = :item10 WHERE id = :id")
    fun atualizaChecklist(id: String, item1: Boolean, item2: Boolean, item3: Boolean, item4: Boolean, item5: Boolean, item6: Boolean, item7: Boolean, item8: Boolean, item9: Boolean, item10: Boolean)

    @Query ("SELECT * FROM CheckList WHERE id = :id")
    fun buscaChecklistPorId(id: String): CheckList

    @Query ("UPDATE CheckList SET status = :status WHERE id = :id")
    fun atualizaStatus(id: String, status: String)

    @Query ("SELECT * FROM CheckList WHERE status = :status")
    fun buscaChecklistPorStatus(status: String): List<CheckList>

    @Query ("SELECT * FROM CheckList WHERE placa = :placa")
    fun buscaChecklistPorPlaca(placa: String): List<CheckList>
}