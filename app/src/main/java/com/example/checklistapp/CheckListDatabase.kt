package com.example.checklistapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CheckList::class], version = 1)
abstract class CheckListDatabase  : RoomDatabase(){
    abstract fun CheckListDao(): CheckListDao
    fun returnBd(context: Context): CheckListDatabase {
        return Room. databaseBuilder(
            context,
            CheckListDatabase::class.java,
            "CheckListDatabase1.db"
        ).allowMainThreadQueries().build()
    }
}