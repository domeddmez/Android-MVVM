/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

@file:JvmName("RecycleViewPage2Adapter")

package com.dome.mvvm.page2

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dome.mvvm.R
import com.dome.mvvm.databinding.ItemlistBinding
import com.example.promptnow.testkotlin.DataModel
import com.google.gson.Gson

class RecycleViewPage2Adapter : RecyclerView.Adapter<RecycleViewPage2Adapter.ViewHolder>() {
    private var data: DataModel? = null

    fun setData(data:DataModel) {
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil
            .inflate<ItemlistBinding>(
                LayoutInflater.from(parent.context), R.layout.itemlist,
                parent, false
            )

        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.item = data!!.categories!![position]
        holder.binding.executePendingBindings()
    }


    override fun getItemCount(): Int {
        return data!!.categories!!.size
    }

    class ViewHolder(val binding: ItemlistBinding) : RecyclerView.ViewHolder(binding.root)
}