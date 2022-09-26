package com.example.androidarchitecturedemo.retrofit.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidarchitecturedemo.retrofit.data.wallpaperDataClass
import com.example.androidarchitecturedemo.retrofit.network.WallpaperInterface

class WallpaperRepository(private val wallpaperInterface: WallpaperInterface) {

        val mutableLiveData = MutableLiveData<wallpaperDataClass>()
        val wallpaper:LiveData<wallpaperDataClass>
            get() = mutableLiveData

    suspend fun getWallpaper(authorization :String,query :String,page:Int,per_page:Int){
        val result = wallpaperInterface.getWallpaper(authorization,query,page,per_page)
        if (result.body() != null){
            mutableLiveData.postValue(result.body())
        }else{
            Log.d("WallpaperResponce", "getWallpaper: ${result.errorBody().toString()}")
        }
    }
}