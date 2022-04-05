package com.example.rijsmuseum.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rijsmuseum.R
import com.example.rijsmuseum.domain.models.ListArtObject

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    //Collections ArtObjects MutableList
    private val cList: MutableList<ListArtObject> = mutableListOf()

    private var mListener: OnClickCallback? = null

    interface OnClickCallback {
        fun onItemClick(cList: ListArtObject)
    }
    fun setOnItemClickListener(listener: OnClickCallback) {
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
        private var imageView: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(data: ListArtObject) {
            titleText.text = data.title

            Glide.with(itemView)
                .load(data.url)
                .circleCrop()
                .into(imageView)
        }

        init {
            //Setting the new interface listener here, using it's position parameter
            itemView.setOnClickListener {
                mListener?.onItemClick(cList[adapterPosition])
            }
        }
    }

    fun updateCollectionsData(listItems: List<ListArtObject>) {
        cList.clear()
        cList.addAll(listItems)
        notifyDataSetChanged()
    }
}