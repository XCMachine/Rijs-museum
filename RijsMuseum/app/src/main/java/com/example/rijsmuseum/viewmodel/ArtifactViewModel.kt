package com.example.rijsmuseum.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.network.getters.CollectionsGetter
import com.example.network.models.Collections

class ArtifactViewModel: ViewModel() {
    private val _cList = MutableLiveData<List<Collections.ArtObject>>()
    val cList: LiveData<List<Collections.ArtObject>> = _cList

    fun getCollectionsRequest() {
        CollectionsGetter().getCollectionRequest(object : CollectionsGetter.DataReadyCallback {
            override fun onDataReady(data: List<Collections.ArtObject>) {
                _cList.value = data
            }
        })
    }
}