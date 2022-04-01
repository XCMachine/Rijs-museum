package com.example.network.resource.getters

import android.util.Log
import com.example.network.Retrofit
import com.example.network.api.CollectionsApiService
import com.example.network.resource.models.CollectionsDetailsResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CollectionsDetailsGetter {

    fun getCollectionsDetailsRequest(
        callback: DataReadyCallback,
        objectNumber: String
    ) {
        val collectionsDetailsApi = Retrofit().getCollectionsInstance().create(CollectionsApiService::class.java)

        //CollectionsDetails model call and callback
        val callCollectionsDetails: Call<CollectionsDetailsResource> = collectionsDetailsApi.getCollectionsDetailsList(culture = "en", format = "json", objectNumber = objectNumber)
        callCollectionsDetails.enqueue(object : Callback<CollectionsDetailsResource> {
            override fun onResponse(
                call: Call<CollectionsDetailsResource>,
                response: Response<CollectionsDetailsResource>
            ) {
                response.body()?.run {
                    callback.onDataReady(this.artObject)
                }
            }

            override fun onFailure(call: Call<CollectionsDetailsResource>, t: Throwable) {
                Log.e("Error", t.localizedMessage!!)
            }

        })
    }

    interface DataReadyCallback {
        fun onDataReady(data: CollectionsDetailsResource.ArtObjectResource)
    }
}