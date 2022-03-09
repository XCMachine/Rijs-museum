package com.example.network

import com.example.network.api.CollectionsApi
import com.example.network.models.Collections
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    private var collectionsList: List<Collections>? = null
    
    private val baseURL = "https://www.rijksmuseum.nl"

    fun getCollectionRequest() {
        //Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val collectionsApi = retrofit.create(CollectionsApi::class.java)

        //Collections model call and callback
        val callCollections: Call<List<Collections>> = collectionsApi.getCollections("en", "json", "0", "10")
        callCollections.enqueue(object : Callback<List<Collections>> {
            override fun onResponse(
                call: Call<List<Collections>>,
                response: Response<List<Collections>>
            ) {
                collectionsList = response.body()
            }

            override fun onFailure(call: Call<List<Collections>>, t: Throwable) {
                if (call.isCanceled) {
                    t.message
                    t.printStackTrace()
                    call.cancel()
                }
            }
        })
    }
}