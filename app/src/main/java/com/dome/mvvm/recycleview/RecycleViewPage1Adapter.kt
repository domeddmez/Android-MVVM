package com.dome.mvvm.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dome.mvvm.R
import com.example.promptnow.testkotlin.DataModel
import kotlinx.android.synthetic.main.itemlist.view.*

/**
 * Created by domez on 11/19/2018.
 */

class RecycleViewPage1Adapter : RecyclerView.Adapter<ViewHolder>() {

    private lateinit var items: DataModel

    override fun onCreateViewHolder(parent: ViewGroup, position : Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.itemlist, parent, false))
    }

    fun setData(items: DataModel) {
        this.items = items
    }

    override fun onBindViewHolder(parent: ViewHolder, position: Int) {
        parent.tvName.text = items.categories!![position].title
        parent.tvId.text = items.categories!![position].id.toString()
        parent.tvSubName.text = items.categories!![position].post_count.toString()

        parent.tvName.setOnClickListener {
            listener.onClick(items.categories!![position].title.toString())
        }
    }

    lateinit var listener: OnItemClickListener
    override fun getItemCount(): Int {
        return items.categories!!.size
    }


    interface OnItemClickListener {
        fun onClick(text: String)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }


}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val tvName = view.tvName!!
    val tvId = view.tvId!!
    val tvSubName = view.tvSubName!!


}

