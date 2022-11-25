package com.example.checklistapp
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
 class CheckList (placa: String,nomeMotorista: String,  status: String, data: String, item1: Boolean  ) {
    @PrimaryKey (autoGenerate = true) var id: Int = 0
    @ColumnInfo var placa: String = placa
    @ColumnInfo var nomeMotorista: String = nomeMotorista
    @ColumnInfo var status: String = status
    @ColumnInfo var data: String = data
    @ColumnInfo var item1: Boolean = item1
    @ColumnInfo var item2: Boolean = false
    @ColumnInfo var item3: Boolean = false
    @ColumnInfo var item4: Boolean = false
    @ColumnInfo var item5: Boolean = false
    @ColumnInfo var item6: Boolean = false
    @ColumnInfo var item7: Boolean = false
    @ColumnInfo var item8: Boolean = false
    @ColumnInfo var item9: Boolean = false
    @ColumnInfo var item10: Boolean = false
}



