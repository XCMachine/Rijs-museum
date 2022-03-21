package com.example.rijsmuseum.viewmodel

import androidx.lifecycle.ViewModel
import com.example.network.getters.CollectionsDetailsGetter

class DetailsViewModel: ViewModel() {
    fun getCollectionsDetailsRequest(
        data: CollectionsDetailsGetter.DataReadyCallback,
        objectNumber: String
    ) {
        CollectionsDetailsGetter().getCollectionsDetailsRequest(data, objectNumber)
    }
}