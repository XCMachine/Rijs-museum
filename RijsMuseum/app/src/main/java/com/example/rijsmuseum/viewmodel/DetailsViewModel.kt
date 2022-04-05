package com.example.rijsmuseum.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.network.resource.getters.CollectionsDetailsGetter
import com.example.network.resource.models.CollectionsDetailsResource
import com.example.rijsmuseum.domain.mappers.mapFromResourceObject
import com.example.rijsmuseum.domain.models.ArtObject

class DetailsViewModel: ViewModel() {
    private val _cDetailsList = MutableLiveData<ArtObject>()
    val cDetailsList: LiveData<ArtObject> = _cDetailsList

    fun getCollectionsDetailsRequest(
        objectNumber: String
    ) {
        CollectionsDetailsGetter().getCollectionsDetailsRequest(
            object : CollectionsDetailsGetter.DataReadyCallback {
                override fun onDataReady(data: CollectionsDetailsResource) {
                    _cDetailsList.value = data.mapFromResourceObject()
                }
            }, objectNumber)
    }
}