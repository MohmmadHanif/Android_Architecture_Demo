package com.example.androidarchitecturedemo.quotes_app_demo

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.androidarchitecturedemo.Utils
import com.google.gson.Gson

class QuotesViewModal(private val application: Application) :ViewModel() {

    var quotesArray:Array<QuotesDataClass> = emptyArray()
    var index:Int = 0

    init {
        quotesArray = readJsonAsset()
    }

     fun readJsonAsset(): Array<QuotesDataClass> {

        val inputStream = application.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json,Array<QuotesDataClass>::class.java)
    }

    fun getQuote() = quotesArray[index]

    fun nextQuote() {
        index++
        if (index > quotesArray.size-1){
            index = 0
            Utils.showToast(application,"All Quotes over Restart")
        }
        quotesArray[index]
    }
    fun previousQuote(): QuotesDataClass {
        index--
        if (index < 0){
            index = 0
            Utils.showToast(application,"No Previous Quotes")
        }
        return quotesArray[index]
    }
}