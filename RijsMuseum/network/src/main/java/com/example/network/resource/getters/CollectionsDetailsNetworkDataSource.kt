package com.example.network.resource.getters

import android.util.Log
import com.example.network.Retrofit
import com.example.network.api.CollectionsApiService
import com.example.network.resource.models.CollectionsDetailsResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CollectionsDetailsNetworkDataSource(
    private val collectionsDetailsApi: CollectionsApiService = Retrofit().getCollectionsInstance().create(CollectionsApiService::class.java)
) {
    fun getCollectionsDetailsRequest(
        callback: DataReadyCallback,
        objectNumber: String
    ) {
        //CollectionsDetails model call and callback
        val callCollectionsDetails: Call<CollectionsDetailsResource> = collectionsDetailsApi.getCollectionsDetails(culture = "en", format = "json", objectNumber = objectNumber)
        callCollectionsDetails.enqueue(object : Callback<CollectionsDetailsResource> {
            override fun onResponse(
                call: Call<CollectionsDetailsResource>,
                response: Response<CollectionsDetailsResource>
            ) {
                response.body()?.run {
                    callback.onDataReady(this)
                }
            }

            override fun onFailure(call: Call<CollectionsDetailsResource>, t: Throwable) {
                Log.e("Error", t.localizedMessage!!)
            }

        })
    }

    interface DataReadyCallback {
        fun onDataReady(data: CollectionsDetailsResource)
    }
}