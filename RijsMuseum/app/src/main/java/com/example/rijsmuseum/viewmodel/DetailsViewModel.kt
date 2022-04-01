package com.example.rijsmuseum.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.network.resource.getters.CollectionsDetailsGetter
import com.example.network.resource.models.CollectionsDetailsResource

class DetailsViewModel: ViewModel() {
    private val _cDetailsList = MutableLiveData<CollectionsDetailsResource.ArtObjectResource>()
    val cDetailsList: LiveData<CollectionsDetailsResource.ArtObjectResource> = _cDetailsList

    fun getCollectionsDetailsRequest(
        objectNumber: String
    ) {
        CollectionsDetailsGetter().getCollectionsDetailsRequest(
            object : CollectionsDetailsGetter.DataReadyCallback {
                override fun onDataReady(data: CollectionsDetailsResource.ArtObjectResource) {
                    _cDetailsList.value = data
                }
            }, objectNumber)
    }
}