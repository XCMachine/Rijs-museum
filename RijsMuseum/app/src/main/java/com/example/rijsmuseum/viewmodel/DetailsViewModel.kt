package com.example.rijsmuseum.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rijsmuseum.domain.models.ArtObject
import com.example.rijsmuseum.repositories.CollectionRepository

class DetailsViewModel: ViewModel() {
    private val _cDetailsList = MutableLiveData<ArtObject>()
    val cDetailsList: LiveData<ArtObject> = _cDetailsList

    fun getCollectionsDetailsRequest(
        objectNumber: String
    ) {
        CollectionRepository().getDataObject(
            mutableLiveData = _cDetailsList,
            objectNumber = objectNumber
        )
    }
}