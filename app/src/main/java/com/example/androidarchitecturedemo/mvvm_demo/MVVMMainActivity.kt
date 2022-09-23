package com.example.androidarchitecturedemo.mvvm_demo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Dao
import com.example.androidarchitecturedemo.R
import com.example.androidarchitecturedemo.databinding.ActivityMvvmmainBinding
import com.example.androidarchitecturedemo.mvvm_demo.repository.MVVMRepository
import com.example.androidarchitecturedemo.mvvm_demo.viewmodal.MVVMMainViewModal
import com.example.androidarchitecturedemo.mvvm_demo.viewmodal.view_modal_factory.MVVMViewModalFactory
import com.example.androidarchitecturedemo.quotes_app_demo.QuotesDataClass
import com.example.androidarchitecturedemo.quotes_app_demo.QuotesMainActivity


class MVVMMainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding :ActivityMvvmmainBinding
    lateinit var viewModal: MVVMMainViewModal
    lateinit var adapter:MVVMAdapter
    private lateinit var list:List<QuotesDataClass>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvmmain)
        val dao = MVVMDataBaseClass.getDatabase(applicationContext).dao()
        val repository = MVVMRepository(dao)
        viewModal = ViewModelProvider(this,MVVMViewModalFactory(repository))[MVVMMainViewModal::class.java]

        viewModal.getAllData().observe(this, Observer {
        adapter = MVVMAdapter(it)
        binding.rvMVVM.adapter = adapter
        })

        binding.MVVMInsertRecordBtn.setOnClickListener(this)
    }

    override fun onClick(id: View?) {
        when(id){
            binding.MVVMInsertRecordBtn -> insetQuote()
        }
    }

    private fun insetQuote() {
        val insertQuotes = MVVMQuotesDataClass(0,getString(R.string.lambi_zubaan_insaan_ko_chhota_kar_deti_hai),"Syed Arif Attari")
        viewModal.insert(insertQuotes)
    }
}