package com.example.rijsmuseum.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.network.models.Collections
import com.example.rijsmuseum.MainActivity
import com.example.rijsmuseum.R

class RecyclerAdapter(listItems: List<Collections>, var context: Context) : RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {
    private var exampleList: List<Collections> = listItems

    private var mListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: MainActivity) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.RecyclerViewHolder {
        val viewInflater = LayoutInflater.from(context).inflate(R.layout.card_items, parent, false)
        return RecyclerViewHolder(viewInflater)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.RecyclerViewHolder, position: Int) {
        val listItem = exampleList[position]

        holder.titleText.text = listItem.artObjects[3].toString()
    }

    override fun getItemCount(): Int = exampleList.size

    inner class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var titleText: TextView = itemView.findViewById(R.id.titleText)

        init {
            itemView.setOnClickListener {
                if (mListener != null) {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        mListener!!.onItemClick(position)
                    }
                }
            }
        }
    }

    init {
        exampleList = listItems
    }

}