package com.example.network.getters

import android.util.Log
import com.example.network.Retrofit
import com.example.network.api.CollectionsApi
import com.example.network.models.CollectionsDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CollectionsDetailsGetter {
    private var collectionsDetailsList: List<CollectionsDetails>? = null

    fun getCollectionsDetailsRequest() {
        val collectionsDetailsApi = Retrofit().builder.create(CollectionsApi::class.java)

        //CollectionsDetails model call and callback
        val callCollections: Call<List<CollectionsDetails>> = collectionsDetailsApi.getCollectionsDetails(
            culture = "en",
            format = "json"
        )

        callCollections.enqueue(object : Callback<List<CollectionsDetails>> {
            override fun onResponse(
                call: Call<List<CollectionsDetails>>,
                response: Response<List<CollectionsDetails>>
            ) {
                collectionsDetailsList = response.body()
            }

            override fun onFailure(call: Call<List<CollectionsDetails>>, t: Throwable) {
                Log.e("Error", t.localizedMessage!!)
            }

        })
    }
}