package com.example.rijsmuseum.repositories

import androidx.lifecycle.MutableLiveData
import com.example.network.resource.getters.CollectionsDetailsGetter
import com.example.network.resource.models.CollectionsDetailsResource
import com.example.rijsmuseum.domain.mappers.mapFromResourceObject
import com.example.rijsmuseum.domain.models.ArtObject

class CollectionsDetailsRepository {
    fun getDataFromService(
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