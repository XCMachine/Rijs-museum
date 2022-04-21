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

object CollectionRepository {
    private val collectionsNetworkDataSource: CollectionsNetworkDataSource =
        CollectionsNetworkDataSource()
    private val collectionsDetailsNetworkDataSource: CollectionsDetailsNetworkDataSource =
        CollectionsDetailsNetworkDataSource()

    //This is the cache variable on a regular object
    private var latestCollections: CollectionsResource? = null
    private var latestCollectionsDetails: MutableMap<String, CollectionsDetailsResource> =
        mutableMapOf()

    //From Collections Resources Model to Domain Model, using Cache variable
    //It needs to return the cache variable to the others
    fun getDataListObjects(
        mutableLiveData: MutableLiveData<List<ListArtObject>>
    ) {
        //Checks if the there is any data within cache, if not to write it
        if (latestCollections != null) {
            latestCollections?.mapFromResourceListObject()?.run {
                mutableLiveData.value = this
            }
        } else {
            collectionsNetworkDataSource.getCollectionRequest(object :
                CollectionsNetworkDataSource.DataReadyCallback {
                override fun onDataReady(data: CollectionsResource) {
                    latestCollections = data
                    latestCollections?.mapFromResourceListObject()?.run {
                        mutableLiveData.value = this
                    }
                }
            })
        }
    }

    //From Collection Details Resources Model to Domain Model, using Cache variables
    fun getDataObject(
        mutableLiveData: MutableLiveData<ArtObject>,
        objectNumber: String
    ) {

        if (latestCollectionsDetails.containsKey(objectNumber)) {
            latestCollectionsDetails[objectNumber]?.run {
                mutableLiveData.value = this.mapFromResourceObject()
            }
        } else {
            collectionsDetailsNetworkDataSource.getCollectionsDetailsRequest(object :
                CollectionsDetailsNetworkDataSource.DataReadyCallback {
                override fun onDataReady(data: CollectionsDetailsResource) {
                    latestCollectionsDetails[objectNumber] = data
                    mutableLiveData.value = data.mapFromResourceObject()
                }
            }, objectNumber)
        }
    }
}