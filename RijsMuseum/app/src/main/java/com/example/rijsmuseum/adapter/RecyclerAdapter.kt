package com.example.rijsmuseum.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.network.models.Collections
import com.example.rijsmuseum.MainActivity
import com.example.rijsmuseum.R

class RecyclerAdapter(listItems: List<Collections>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private var exampleList: ArrayList<Collections> = listItems as ArrayList<Collections>

    private var mListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: MainActivity) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(exampleList[position], position)
    }

    override fun getItemCount(): Int {
        return exampleList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        lateinit var titleText: TextView

        fun bind(data: Collections, position: Int) {
            titleText.text = data.artObjects[position].title
        }

        init {
            //Setting the new interface listener here, using it's position parameter
            itemView.setOnClickListener {
                titleText = itemView.findViewById(R.id.titleText)
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
        exampleList = listItems as ArrayList<Collections>
    }
}