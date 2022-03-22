package com.example.rijsmuseum.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.network.getters.CollectionsDetailsGetter
import com.example.network.models.CollectionsDetails

class DetailsViewModel: ViewModel() {
    private val _cList = MutableLiveData<CollectionsDetails.ArtObject>()
    val cList: LiveData<CollectionsDetails.ArtObject> = _cList

    fun getCollectionsDetailsRequest(
        objectNumber: String
    ) {
        CollectionsDetailsGetter().getCollectionsDetailsRequest(
            object : CollectionsDetailsGetter.DataReadyCallback {
                override fun onDataReady(data: CollectionsDetails.ArtObject) {
                    _cList.value = data
                }
            }, objectNumber)
    }
}