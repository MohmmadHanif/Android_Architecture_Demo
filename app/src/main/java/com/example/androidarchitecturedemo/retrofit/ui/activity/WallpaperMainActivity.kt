package com.example.androidarchitecturedemo.retrofit.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecturedemo.R
import com.example.androidarchitecturedemo.retrofit.network.WallpaperApiUtils
import com.example.androidarchitecturedemo.retrofit.network.WallpaperInterface
import com.example.androidarchitecturedemo.retrofit.repository.WallpaperRepository
import com.example.androidarchitecturedemo.retrofit.ui.viewmodal.WallpaperViewModal
import com.example.androidarchitecturedemo.retrofit.ui.viewmodal.WallpaperViewModalFactory
import com.example.androidarchitecturedemo.retrofit_mvvm.repository.RetrofitRepository

class WallpaperMainActivity : AppCompatActivity() {
    private lateinit var viewModal: WallpaperViewModal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallpaper_main)
        val network = WallpaperApiUtils.getInstance().create(WallpaperInterface::class.java)
        val repository = WallpaperRepository(network)
        viewModal = ViewModelProvider(this,WallpaperViewModalFactory(repository))[WallpaperViewModal::class.java]

        viewModal.wallpaper.observe(this, Observer {
            it.photos.forEach {
                Log.d("WallpaperResponce", "onCreate:"+ it.src.medium)
            }
        })
    }
}