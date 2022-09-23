package com.example.androidarchitecturedemo.mvvm_demo

import android.content.Context
import android.content.Entity
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MVVMQuotesDataClass::class], version = 1)
abstract class MVVMDataBaseClass : RoomDatabase() {
    abstract fun dao(): MVVMDao

    companion object {
        private var INSTANCE: MVVMDataBaseClass? = null

        fun getDatabase(context: Context): MVVMDataBaseClass {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(context,
                        MVVMDataBaseClass::class.java,
                        "Quotes_DB")
                        .createFromAsset("quotes.db")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}