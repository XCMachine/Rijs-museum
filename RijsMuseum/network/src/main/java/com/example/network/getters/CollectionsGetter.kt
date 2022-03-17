package com.example.network.getters

import android.util.Log
import com.example.network.Retrofit
import com.example.network.api.CollectionsApiService
import com.example.network.models.Collections
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CollectionsGetter {

    fun getCollectionRequest(
        callback: DataReadyCallback
    ) {
        val collectionsApi = Retrofit().getCollectionsInstance().create(CollectionsApiService::class.java)

        //Collections model call and callback
        val callCollections: Call<Collections> = collectionsApi.getCollectionsList(culture = "en", page = "0", pages = "10")
        callCollections.enqueue(object : Callback<Collections> {
            override fun onResponse(
                call: Call<Collections>,
                response: Response<Collections>
            ) {
                response.body()?.run {
                    callback.onDataReady(this.artObjects)
                }
            }

            override fun onFailure(call: Call<Collections>, t: Throwable) {
                Log.e("Error", t.localizedMessage!!)
            }
        })
    }

    interface DataReadyCallback{
        fun onDataReady(data: List<Collections.ArtObject>)
    }
}