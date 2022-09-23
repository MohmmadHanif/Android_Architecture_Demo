package com.example.androidarchitecturedemo.mvvm_demo.repository

import androidx.lifecycle.LiveData
import com.example.androidarchitecturedemo.mvvm_demo.MVVMDao
import com.example.androidarchitecturedemo.mvvm_demo.MVVMQuotesDataClass
import com.example.androidarchitecturedemo.quotes_app_demo.QuotesDataClass


class MVVMRepository(val dao: MVVMDao){

    fun getAllQuotes() :LiveData<List<MVVMQuotesDataClass>>{
        return dao.getAllQuotes()
    }

    suspend fun insertQuotes(quotesDataClass: MVVMQuotesDataClass){
        dao.insertQuotes(quotesDataClass)
    }
}