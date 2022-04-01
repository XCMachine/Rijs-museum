package com.example.rijsmuseum.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.network.resource.getters.CollectionsGetter
import com.example.network.resource.models.CollectionsResource

class ArtifactsViewModel: ViewModel() {
    private val _cList = MutableLiveData<List<CollectionsResource.ArtObjectResource>>()
    val cList: LiveData<List<CollectionsResource.ArtObjectResource>> = _cList

    fun getCollectionsRequest() {
        CollectionsGetter().getCollectionRequest(object : CollectionsGetter.DataReadyCallback {
            override fun onDataReady(data: List<CollectionsResource.ArtObjectResource>) {
                _cList.value = data
            }
        })
    }
}