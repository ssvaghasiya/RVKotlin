package com.example.rvkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.OrientationEventListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.rvkotlin.model.Data
import com.example.rvkotlin.model.ReqresUser
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var dataList: MutableList<Data> = mutableListOf()
    lateinit var myadapter : ExampleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val example = generateDummyList(200)
        myadapter = ExampleAdapter(dataList)

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = myadapter
        recycler_view.setHasFixedSize(true)


        AndroidNetworking.initialize(this)

        AndroidNetworking.get("https://reqres.in/api/users?page=2").build().getAsObject(ReqresUser::class.java,object : ParsedRequestListener<ReqresUser>{

            override fun onResponse(response: ReqresUser?) {
                if (response != null) {
                    dataList.addAll(response.data)
                }
                myadapter.notifyDataSetChanged()
            }

            override fun onError(anError: ANError?) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun generateDummyList(size: Int): List<ExampleItem>{
        val list = ArrayList<ExampleItem>()

        for(i in 0 until size){
            val drawable = R.drawable.ic_baseline_accessibility_new_24
            val item = ExampleItem(drawable, "admin $i","test")
            list += item
        }
        return list
    }
}