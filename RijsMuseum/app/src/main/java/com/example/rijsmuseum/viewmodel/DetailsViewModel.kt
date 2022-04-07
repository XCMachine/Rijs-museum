package com.example.rijsmuseum.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rijsmuseum.domain.models.ArtObject
import com.example.rijsmuseum.repositories.CollectionsDetailsRepository

class DetailsViewModel: ViewModel() {
    private val _cDetailsList = MutableLiveData<ArtObject>()
    val cDetailsList: LiveData<ArtObject> = _cDetailsList

    fun getCollectionsDetailsRequest(
        objectNumber: String
    ) {
        CollectionsDetailsRepository().getDataFromService(
            mutableLiveData = _cDetailsList,
            objectNumber = objectNumber
        )
    }
}