package com.example.network.getters

import android.util.Log
import com.example.network.Retrofit
import com.example.network.api.CollectionsApiService
import com.example.network.models.CollectionsDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CollectionsDetailsGetter {

    fun getCollectionsDetailsRequest(
        callback: DataReadyCallback
    ) {
        val collectionsDetailsApi = Retrofit().getCollectionsInstance().create(CollectionsApiService::class.java)

        //CollectionsDetails model call and callback
        val callCollections: Call<CollectionsDetails> = collectionsDetailsApi.getCollectionsDetailsList(culture = "en", objectNumber = "SK-C-5", format = "json")
        callCollections.enqueue(object : Callback<CollectionsDetails> {
            override fun onResponse(
                call: Call<CollectionsDetails>,
                response: Response<CollectionsDetails>
            ) {
                response.body()?.run {
                    callback.onDataReady(this.artObject)
                }
            }

            override fun onFailure(call: Call<CollectionsDetails>, t: Throwable) {
                Log.e("Error", t.localizedMessage!!)
            }

        })
    }

    interface DataReadyCallback {
        fun onDataReady(data: CollectionsDetails.ArtObject)
    }
}