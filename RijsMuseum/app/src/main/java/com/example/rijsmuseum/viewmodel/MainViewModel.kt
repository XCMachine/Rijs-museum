package com.example.rijsmuseum.viewmodel

import androidx.lifecycle.ViewModel
import com.example.network.getters.CollectionsDetailsGetter
import com.example.network.getters.CollectionsGetter
import com.example.network.models.Collections
import com.example.network.models.CollectionsDetails

class MainViewModel: ViewModel() {
    //Collections model
    var artObjects: MutableList<Collections.ArtObject> = mutableListOf()
    //CollectionsDetails model
    var artObjectsDetails: MutableList<CollectionsDetails.ArtObject> = mutableListOf()

    fun getCollectionsRequest(callback: CollectionsGetter.DataReadyCallback) {
        CollectionsGetter().getCollectionRequest(callback)
    }

    fun getCollectionsDetailsRequest(callbackDetails: CollectionsDetailsGetter.DataReadyCallback) {
        CollectionsDetailsGetter().getCollectionsDetailsRequest(callbackDetails)
    }


}