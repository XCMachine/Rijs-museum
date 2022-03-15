package com.example.rijsmuseum.viewmodel

import androidx.lifecycle.ViewModel
import com.example.network.getters.CollectionsDetailsGetter
import com.example.network.getters.CollectionsGetter
import com.example.network.models.Collections

class MainViewModel: ViewModel() {
    var exampleList: List<Collections>? = null

    fun getCollectionsRequest() {
        CollectionsGetter().getCollectionRequest()
    }

    fun getCollectionsDetailsRequest() {
        CollectionsDetailsGetter().getCollectionsDetailsRequest()
    }
}