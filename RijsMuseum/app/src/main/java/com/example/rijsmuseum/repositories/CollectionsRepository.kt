package com.example.rijsmuseum.repositories

import androidx.lifecycle.MutableLiveData
import com.example.network.resource.getters.CollectionsGetter
import com.example.network.resource.models.CollectionsResource
import com.example.rijsmuseum.domain.mappers.mapFromResourceListObject
import com.example.rijsmuseum.domain.models.ListArtObject

class CollectionsRepository {
    //From Collections Resources Model to Domain Model
    fun getDataFromService(mutableLiveData: MutableLiveData<List<ListArtObject>>) {
        CollectionsGetter().getCollectionRequest(object : CollectionsGetter.DataReadyCallback {
            override fun onDataReady(data: CollectionsResource) {
                mutableLiveData.value = data.mapFromResourceListObject()
            }
        })
    }
}