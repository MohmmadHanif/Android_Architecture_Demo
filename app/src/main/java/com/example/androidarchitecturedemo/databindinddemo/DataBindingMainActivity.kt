package com.example.androidarchitecturedemo.databindinddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.androidarchitecturedemo.R
import com.example.androidarchitecturedemo.databinding.ActivityDataMainBinding

class DataBindingMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityDataMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_data_main)

        val demoQuotesDataClass = DemoQuotesDataClass(getString(R.string.lambi_zubaan_insaan_ko_chhota_kar_deti_hai),"SyedArifAttari")
        binding.quotes = demoQuotesDataClass
        /**
         * Simple Using FindViewBy Id
         */
        /*val text: TextView = findViewById<TextView>(R.id.text)
        val author: TextView = findViewById<TextView>(R.id.author)
        text.text = getString(R.string.databindingquotetext)
        author.text = getString(R.string.author)*/

        /**
         * Using Binding
         */
        /*binding.text.text = getString(R.string.databindingquotetext)
        binding.author.text = getString(R.string.author)*/



    }
}