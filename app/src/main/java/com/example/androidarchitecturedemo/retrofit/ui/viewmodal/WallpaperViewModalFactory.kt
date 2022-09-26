package com.example.androidarchitecturedemo.retrofit.ui.viewmodal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecturedemo.retrofit.repository.WallpaperRepository

class WallpaperViewModalFactory(val wallpaperRepository: WallpaperRepository) :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WallpaperViewModal(wallpaperRepository) as T
    }
}