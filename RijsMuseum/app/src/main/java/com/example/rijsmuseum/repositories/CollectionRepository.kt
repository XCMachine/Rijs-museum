package com.example.rijsmuseum.repositories

import androidx.lifecycle.MutableLiveData
import com.example.network.resource.getters.CollectionsDetailsNetworkDataSource
import com.example.network.resource.getters.CollectionsNetworkDataSource
import com.example.network.resource.models.CollectionsDetailsResource
import com.example.network.resource.models.CollectionsResource
import com.example.rijsmuseum.domain.mappers.mapFromResourceListObject
import com.example.rijsmuseum.domain.mappers.mapFromResourceObject
import com.example.rijsmuseum.domain.models.ArtObject
import com.example.rijsmuseum.domain.models.ListArtObject

class CollectionRepository(
    private val collectionsNetworkDataSource: CollectionsNetworkDataSource = CollectionsNetworkDataSource(),
    private val collectionsDetailsNetworkDataSource: CollectionsDetailsNetworkDataSource = CollectionsDetailsNetworkDataSource()
) {
    //This is the cache variable on a regular object
    private var latestCollections: CollectionsResource? = null
    private var latestCollectionsDetails: CollectionsDetailsResource? = null

    //From Collections Resources Model to Domain Model, using Cache variables
    fun getDataListObjects(
        mutableLiveData: MutableLiveData<List<ListArtObject>>
    ) {
        collectionsNetworkDataSource.getCollectionRequest(object : CollectionsNetworkDataSource.DataReadyCallback {
            override fun onDataReady(data: CollectionsResource) {
                latestCollections = data
                latestCollections?.mapFromResourceListObject()?.run { mutableLiveData.value = this }
            }
        })
    }

    //From Collection Details Resources Model to Domain Model, using Cache variables
    fun getDataObject(
        mutableLiveData: MutableLiveData<ArtObject>,
        objectNumber: String
    ) {
        collectionsDetailsNetworkDataSource.getCollectionsDetailsRequest(object : CollectionsDetailsNetworkDataSource.DataReadyCallback {
            override fun onDataReady(data: CollectionsDetailsResource) {
                latestCollectionsDetails = data
                latestCollectionsDetails?.mapFromResourceObject()?.run { mutableLiveData.value = this }
            }
        }, objectNumber)
    }
}