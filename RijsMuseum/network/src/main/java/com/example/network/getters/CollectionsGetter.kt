package com.example.network.getters

import android.util.Log
import com.example.network.Retrofit
import com.example.network.api.CollectionsApi
import com.example.network.models.Collections
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CollectionsGetter {
    private var collectionsList: List<Collections>? = null

    fun getCollectionRequest() {
        val collectionsApi = Retrofit().builder.create(CollectionsApi::class.java)

        //Collections model call and callback
        val callCollections: Call<List<Collections>> = collectionsApi.getCollections(culture = "en", page = "0", pages = "10")
        callCollections.enqueue(object : Callback<List<Collections>> {
            override fun onResponse(
                call: Call<List<Collections>>,
                response: Response<List<Collections>>
            ) {
                collectionsList = response.body()
            }

            override fun onFailure(call: Call<List<Collections>>, t: Throwable) {
                Log.e("Error", t.localizedMessage!!)
            }
        })
    }
}