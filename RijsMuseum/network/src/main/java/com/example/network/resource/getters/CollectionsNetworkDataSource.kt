package com.example.network.resource.getters

import android.util.Log
import com.example.network.Retrofit
import com.example.network.api.CollectionsApiService
import com.example.network.resource.models.CollectionsResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CollectionsNetworkDataSource(
    private val collectionsApi: CollectionsApiService = Retrofit().getCollectionsInstance().create(CollectionsApiService::class.java)
) {
    fun getCollectionRequest(
        callback: DataReadyCallback
    ) {
        //Collections model call and callback
        val callCollections: Call<CollectionsResource> = collectionsApi.getCollectionsList(culture = "en", page = "0", pages = "10")
        callCollections.enqueue(object : Callback<CollectionsResource> {
            override fun onResponse(
                call: Call<CollectionsResource>,
                response: Response<CollectionsResource>
            ) {
                response.body()?.run {
                    callback.onDataReady(this)
                }
            }

            override fun onFailure(call: Call<CollectionsResource>, t: Throwable) {
                Log.e("Error", t.localizedMessage!!)
            }
        })
    }

    interface DataReadyCallback{
        fun onDataReady(data: CollectionsResource)
    }
}