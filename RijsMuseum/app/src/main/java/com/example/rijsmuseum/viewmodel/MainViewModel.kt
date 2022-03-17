package com.example.rijsmuseum.viewmodel

import androidx.lifecycle.ViewModel
import com.example.network.getters.CollectionsDetailsGetter
import com.example.network.getters.CollectionsGetter
import com.example.network.models.Collections

class MainViewModel: ViewModel() {
    var artObjects: MutableList<Collections.ArtObject> = mutableListOf()

    fun getCollectionsRequest(callback: CollectionsGetter.DataReadyCallback) {
        CollectionsGetter().getCollectionRequest(callback)
    }

    fun getCollectionsDetailsRequest() {
        CollectionsDetailsGetter().getCollectionsDetailsRequest()
    }


}