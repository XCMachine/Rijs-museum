package com.example.rijsmuseum.viewmodel

import androidx.lifecycle.ViewModel
import com.example.network.getters.CollectionsDetailsGetter
import com.example.network.getters.CollectionsGetter
import com.example.network.models.Collections

class MainViewModel: ViewModel() {
    val exampleList: List<Collections> = listOf()

    fun getCollectionsRequest() {
        CollectionsGetter().getCollectionRequest()
    }

    fun getCollectionsDetailsRequest() {
        CollectionsDetailsGetter().getCollectionsDetailsRequest()
    }
}