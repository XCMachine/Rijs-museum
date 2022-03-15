package com.example.rijsmuseum.viewmodel

import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.network.getters.CollectionsDetailsGetter
import com.example.network.getters.CollectionsGetter
import com.example.network.models.Collections
import com.example.rijsmuseum.MainActivity
import com.example.rijsmuseum.adapter.RecyclerAdapter

class MainViewModel: ViewModel() {
    val exampleList: List<Collections> = listOf()

    fun getCollectionsRequest() {
        CollectionsGetter().getCollectionRequest()
    }

    fun adapterSettings(
        adapter: RecyclerAdapter,
        recyclerView: RecyclerView,
        listener: MainActivity
    ) {
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(listener)
    }

    fun getCollectionsDetailsRequest() {
        CollectionsDetailsGetter().getCollectionsDetailsRequest()
    }
}