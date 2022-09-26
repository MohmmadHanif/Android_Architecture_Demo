package com.example.androidarchitecturedemo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.androidarchitecturedemo.databindinddemo.DataBindingMainActivity
import com.example.androidarchitecturedemo.databindinddemo.dataBindingAnotherExample.OneWayDataBDMainActivity
import com.example.androidarchitecturedemo.databinding.ActivityMainBinding
import com.example.androidarchitecturedemo.diffutil_list_adapter.DiffUilsAndListAdapterMainActivity
import com.example.androidarchitecturedemo.lifecycle.LifeCycleAwareComponents
import com.example.androidarchitecturedemo.livedata.LivedataMainActivity
import com.example.androidarchitecturedemo.mvvm_demo.MVVMMainActivity
import com.example.androidarchitecturedemo.quotes_app_demo.QuotesMainActivity
import com.example.androidarchitecturedemo.retrofit.ui.activity.WallpaperMainActivity
import com.example.androidarchitecturedemo.retrofit_mvvm.ui.activitys.RetrofitWithMVVMMainActivity
import com.example.androidarchitecturedemo.viewmodaldemo.ViewModalMainActivity

class MainActivity : AppCompatActivity(), OnClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dataBinding.setOnClickListener(this)
        binding.lifeCycleComponents.setOnClickListener(this)
        binding.viewModal.setOnClickListener(this)
        binding.quotes.setOnClickListener(this)
        binding.liveData.setOnClickListener(this)
        binding.oneWayDataBinding.setOnClickListener(this)
        binding.MVVMDemo.setOnClickListener(this)
        binding.ListAdapter.setOnClickListener(this)
        binding.ApiCallingUsingMVVM.setOnClickListener(this)
        binding.WallpaperUsingRetrofitWithMVVM.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v) {
            binding.dataBinding -> goToActivity(this, DataBindingMainActivity::class.java)
            binding.lifeCycleComponents -> goToActivity(this, LifeCycleAwareComponents::class.java)
            binding.viewModal -> goToActivity(this, ViewModalMainActivity::class.java)
            binding.quotes -> goToActivity(this, QuotesMainActivity::class.java)
            binding.liveData -> goToActivity(this, LivedataMainActivity::class.java)
            binding.oneWayDataBinding -> goToActivity(this, OneWayDataBDMainActivity::class.java)
            binding.MVVMDemo -> goToActivity(this, MVVMMainActivity::class.java)
            binding.ListAdapter -> goToActivity(this, DiffUilsAndListAdapterMainActivity::class.java)
            binding.ApiCallingUsingMVVM -> goToActivity(this, RetrofitWithMVVMMainActivity::class.java)
            binding.WallpaperUsingRetrofitWithMVVM -> goToActivity(this, WallpaperMainActivity::class.java)
        }
    }

    fun goToActivity(activity: Activity, classs: Class<*>?) {
        val intent = Intent(activity, classs)
        startActivity(intent)
        activity.finish()
    }
}