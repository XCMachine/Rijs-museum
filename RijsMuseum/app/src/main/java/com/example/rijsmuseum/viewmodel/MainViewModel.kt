package com.example.rijsmuseum.viewmodel

import androidx.lifecycle.ViewModel
import com.example.network.getters.CollectionsGetter

class MainViewModel: ViewModel() {
    fun getCollectionsRequest(callback: CollectionsGetter.DataReadyCallback) {
        CollectionsGetter().getCollectionRequest(callback)
    }
}