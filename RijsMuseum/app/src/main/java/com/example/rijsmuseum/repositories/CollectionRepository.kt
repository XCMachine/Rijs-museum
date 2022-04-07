package com.example.rijsmuseum.repositories

import androidx.lifecycle.MutableLiveData
import com.example.network.resource.getters.CollectionsDetailsGetter
import com.example.network.resource.getters.CollectionsGetter
import com.example.network.resource.models.CollectionsDetailsResource
import com.example.network.resource.models.CollectionsResource
import com.example.rijsmuseum.domain.mappers.mapFromResourceListObject
import com.example.rijsmuseum.domain.mappers.mapFromResourceObject
import com.example.rijsmuseum.domain.models.ArtObject
import com.example.rijsmuseum.domain.models.ListArtObject

class CollectionRepository {
    //From Collections Resources Model to Domain Model
    fun getDataListObjects(mutableLiveData: MutableLiveData<List<ListArtObject>>) {
        CollectionsGetter().getCollectionRequest(object : CollectionsGetter.DataReadyCallback {
            override fun onDataReady(data: CollectionsResource) {
                mutableLiveData.value = data.mapFromResourceListObject()
            }
        })
    }

    //From Collection Details Resources Model to Domain Model
    fun getDataObject(
        mutableLiveData: MutableLiveData<ArtObject>,
        objectNumber: String
    ) {
        CollectionsDetailsGetter().getCollectionsDetailsRequest(object : CollectionsDetailsGetter.DataReadyCallback {
            override fun onDataReady(data: CollectionsDetailsResource) {
                mutableLiveData.value = data.mapFromResourceObject()
            }
        }, objectNumber)
    }
}