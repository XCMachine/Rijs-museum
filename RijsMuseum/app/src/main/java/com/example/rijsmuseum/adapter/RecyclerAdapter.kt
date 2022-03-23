package com.example.rijsmuseum.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.network.models.Collections
import com.example.rijsmuseum.R
import com.example.rijsmuseum.fragments.ArtifactFragment

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    //Collections ArtObjects MutableList
    private val cList: MutableList<Collections.ArtObject> = mutableListOf()
    //private val cDetailsArtObject: CollectionsDetails.ArtObject? = null

    private var mListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(cList: Collections.ArtObject)
    }
    fun setOnItemClickListener(listener: ArtifactFragment) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cList[position])
    }

    override fun getItemCount(): Int {
        return cList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var titleText: TextView = itemView.findViewById(R.id.titleText)

        fun bind(data: Collections.ArtObject) {
            titleText.text = data.title
        }

        init {
            //Setting the new interface listener here, using it's position parameter
            itemView.setOnClickListener {
                if (mListener != null) {
                    mListener!!.onItemClick(cList[adapterPosition])
                }
            }
        }
    }

    fun updateCollectionsData(listItems: List<Collections.ArtObject>) {
        cList.clear()
        cList.addAll(listItems)
        notifyDataSetChanged()
    }
}