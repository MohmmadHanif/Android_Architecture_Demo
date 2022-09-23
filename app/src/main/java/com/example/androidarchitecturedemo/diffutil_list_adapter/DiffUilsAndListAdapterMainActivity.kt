package com.example.androidarchitecturedemo.diffutil_list_adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.RecyclerView
import com.example.androidarchitecturedemo.R

class DiffUilsAndListAdapterMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diff_uils_and_list_adapter_main)
        val recyclerView = findViewById<RecyclerView>(R.id.diffUtilRecyclerView)

        val p1 = deffUtilsDataClass(1,"Hanif","8153815190")
        val p2 = deffUtilsDataClass(2,"gullo","6353605485")
        val p3 = deffUtilsDataClass(3,"saif","1234567890")
        val p4 = deffUtilsDataClass(4,"sabbir","9874563210")

        val list:List<deffUtilsDataClass> = listOf(p1,p2,p3,p4)

        val adapter:DiffUtillAndListAdapter = DiffUtillAndListAdapter()
        adapter.submitList(list)
        recyclerView.adapter = adapter

        Handler(Looper.getMainLooper()).postDelayed( {
            val p11 = deffUtilsDataClass(1,"Hanif","8153815190")
            val p12 = deffUtilsDataClass(2,"shaikh","6353605485")
            val p22 = deffUtilsDataClass(6,"hitesh","6353605485")
            val p33 = deffUtilsDataClass(7,"Heet","1234567890")
            val p45 = deffUtilsDataClass(4,"saif","9874563210")
            val p44 = deffUtilsDataClass(8,"pritesh","9874563210")
            val p5 = deffUtilsDataClass(9,"dhaval","9874563210")

            val list1:List<deffUtilsDataClass> = listOf(p11,p12,p22,p33,p44,p5,p45)
            adapter.submitList(list1)
        },5000)
    }
}