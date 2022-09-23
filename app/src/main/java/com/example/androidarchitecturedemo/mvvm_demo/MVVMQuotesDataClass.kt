package com.example.androidarchitecturedemo.mvvm_demo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class MVVMQuotesDataClass(

    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val text:String ,
    val author:String)
