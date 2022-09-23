package com.example.androidarchitecturedemo.databindinddemo.dataBindingAnotherExample

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecturedemo.R
import com.example.androidarchitecturedemo.databinding.ActivityOneWayDataBdMainBinding


class OneWayDataBDMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityOneWayDataBdMainBinding
    lateinit var viewModal: OneWayDataBindingViewModal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_one_way_data_bd_main)
        viewModal = ViewModelProvider(this)[OneWayDataBindingViewModal::class.java]
        binding.lifecycleOwner = this
        /*viewModal.quotes.observe(this) {
            binding.oneWayDataBindingQuote.text = it
        }*/
        val oneWayDataClass = OneWayDataClass("Hanif","Shaikh","https://cdn5.f-cdn.com/contestentries/1735480/33173442/5e5767a3a9bdd_thumb900.jpg")
        //
        fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)
        //binding.editOneWayDataBindingQuote.text = viewModal.quotes.value!!.toEditable()
        binding.editOneWayDataBindingQuote.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                viewModal.userBonusNumber.value = s.toString()
                viewModal.userBonusNumber.observe(this@OneWayDataBDMainActivity, Observer {
                    binding.oneWayDataBindingQuote.text = it
                })
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int,
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int,
            ) {

            }
        })
        binding.modal = oneWayDataClass
        binding.oneWayViewModal = viewModal
    }
}