package com.example.androidarchitecturedemo.databindinddemo

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.androidarchitecturedemo.R
import java.net.URL

@BindingAdapter("imageFromUrl")
fun ImageView.imageFromUrl(url: String){
    Glide
        .with(this.context)
        .load(url)
        .placeholder(R.drawable.ic_baseline_format_quote_24)
        .into(this);
}
