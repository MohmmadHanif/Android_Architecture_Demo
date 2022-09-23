package com.example.androidarchitecturedemo.quotes_app_demo

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecturedemo.databinding.ActivityQuotesMainBinding

class QuotesMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityQuotesMainBinding
    lateinit var quotesViewModal: QuotesViewModal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuotesMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        quotesViewModal = ViewModelProvider(this,QuotesViewModalFactory(application))[QuotesViewModal::class.java]
        setQuote(quotesViewModal.getQuote())

        binding.previous.setOnClickListener(){
            quotesViewModal.previousQuote()
            setQuote(quotesViewModal.getQuote())
        }

        binding.next.setOnClickListener(){
            quotesViewModal.nextQuote()
            setQuote(quotesViewModal.getQuote())
        }
    }

    private fun setQuote(quote:QuotesDataClass) {
        binding.quoteText.text = quote.text
        binding.quoteAuthor.text = quote.author
    }

}