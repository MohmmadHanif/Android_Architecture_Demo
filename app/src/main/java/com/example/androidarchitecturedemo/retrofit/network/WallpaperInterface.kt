package com.example.androidarchitecturedemo.retrofit.network

import com.example.androidarchitecturedemo.retrofit.data.wallpaperDataClass
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface WallpaperInterface {
    @GET("/search")
    suspend fun getWallpaper(
        @Header("Authorization") Authorization:String,
        @Query("query") query:String,
        @Query("page") page:Int,
        @Query("per_page") per_page:Int
    ) : Response<wallpaperDataClass>
}