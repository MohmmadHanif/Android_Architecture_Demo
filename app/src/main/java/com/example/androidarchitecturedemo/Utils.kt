package com.example.androidarchitecturedemo

import android.content.Context
import android.widget.Toast

class Utils {
    companion object {
        fun showToast(context: Context, massage: String) {
        Toast.makeText(context,massage, Toast.LENGTH_LONG).show()
        }
    }
}