package com.example.androidarchitecturedemo.mvvm_demo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.androidarchitecturedemo.quotes_app_demo.QuotesDataClass

@Dao
interface MVVMDao {

    @Query("Select * From quote")
    fun getAllQuotes() :LiveData<List<MVVMQuotesDataClass>>

    @Insert()
     fun insertQuotes(quotes: MVVMQuotesDataClass)
}