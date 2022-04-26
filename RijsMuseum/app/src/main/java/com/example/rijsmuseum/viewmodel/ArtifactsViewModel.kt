package com.example.rijsmuseum.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rijsmuseum.domain.models.ListArtObject
import com.example.rijsmuseum.repositories.CollectionRepository
import java.util.*

class ArtifactsViewModel: ViewModel() {
    private val _cList = MutableLiveData<List<ListArtObject>>()
    val cList: LiveData<List<ListArtObject>> = _cList

    fun getCollectionsRequest() {
        CollectionRepository.getDataListObjects(_cList)
    }

    fun sortListByDescending() {
        _cList.value?.let { list ->
            Collections.sort(list) { listAO1, listAO2 ->
                listAO2.title.compareTo(listAO1.title)
            }
        }
    }
}