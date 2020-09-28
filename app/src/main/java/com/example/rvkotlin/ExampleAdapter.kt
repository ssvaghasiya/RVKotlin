package com.example.rvkotlin

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import com.example.rvkotlin.model.Data
import kotlinx.android.synthetic.main.example_item.view.*

class ExampleAdapter(private val exapmleList: MutableList<Data>): RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.example_item,parent,false)
        return ExampleViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return exapmleList.size
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        var currentItem = exapmleList[position]

//        holder.imageview.setImageResource(currentItem.avatar)
        holder.textView1.text = currentItem.email
        holder.textView2.text = currentItem.firstName

    }

    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val imageview: ImageView = itemView.image_view
        val textView1: TextView = itemView.text_view_1
        val textView2: TextView = itemView.text_view_2
    }
}