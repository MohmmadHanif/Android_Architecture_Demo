package com.example.androidarchitecturedemo.retrofit_mvvm.network


import com.example.androidarchitecturedemo.retrofit_mvvm.dataclass.SimpleJsonDataClassItem
import retrofit2.Response
import retrofit2.http.GET

interface Network {

    @GET("/posts")
    suspend fun getData(): Response<SimpleJsonDataClassItem>
}