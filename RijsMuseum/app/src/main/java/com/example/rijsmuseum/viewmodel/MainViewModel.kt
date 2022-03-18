package com.example.rijsmuseum.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.network.getters.CollectionsDetailsGetter
import com.example.network.getters.CollectionsGetter
import com.example.network.models.Collections
import com.example.network.models.CollectionsDetails

class MainViewModel: ViewModel() {
    //Collections model
    var artObjects: MutableList<Collections.ArtObject> = mutableListOf()
    //CollectionsDetails model
    //Maybe a MutableLiveData is the correct type?
    var artObjectsDetails: MutableLiveData<CollectionsDetails.ArtObject>? = null

    fun getCollectionsRequest(callback: CollectionsGetter.DataReadyCallback) {
        CollectionsGetter().getCollectionRequest(callback)
    }

    fun getCollectionsDetailsRequest(callbackDetails: CollectionsDetailsGetter.DataReadyCallback) {
        CollectionsDetailsGetter().getCollectionsDetailsRequest(callbackDetails)
    }


}