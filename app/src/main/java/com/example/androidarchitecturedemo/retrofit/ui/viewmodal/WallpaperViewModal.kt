package com.example.androidarchitecturedemo.retrofit.ui.viewmodal

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidarchitecturedemo.retrofit.data.wallpaperDataClass
import com.example.androidarchitecturedemo.retrofit.repository.WallpaperRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WallpaperViewModal(val wallpaperRepository: WallpaperRepository) : ViewModel() {
    private val auth = "563492ad6f9170000100000126c8255946ca419fad3c8fc1fdfe9ec5"
    init {
        viewModelScope.launch(Dispatchers.IO){
            wallpaperRepository.getWallpaper(auth,"nature",1,80)
        }
    }

    val wallpaper :LiveData<wallpaperDataClass>
        get() = wallpaperRepository.wallpaper
}