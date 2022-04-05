package com.example.rijsmuseum.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.network.resource.getters.CollectionsGetter
import com.example.network.resource.models.CollectionsResource
import com.example.rijsmuseum.domain.mappers.mapFromResourceListObject
import com.example.rijsmuseum.domain.models.ListArtObject

class ArtifactsViewModel: ViewModel() {
    private val _cList = MutableLiveData<List<ListArtObject>>()
    val cList: LiveData<List<ListArtObject>> = _cList

    fun getCollectionsRequest() {
        CollectionsGetter().getCollectionRequest(object : CollectionsGetter.DataReadyCallback {
            override fun onDataReady(data: CollectionsResource) {
                _cList.value = data.mapFromResourceListObject()
            }
        })
    }
}