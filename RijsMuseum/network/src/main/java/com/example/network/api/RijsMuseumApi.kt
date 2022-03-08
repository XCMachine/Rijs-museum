package com.example.network.api

import com.example.network.get.Collections
import com.example.network.get.CollectionsDetails
import retrofit2.Call
import retrofit2.http.GET

interface RijsMuseumApi {
    //Base URL: https://www.rijksmuseum.nl

    //Gets the collections api
    @GET("/api/nl/collection/SK-C-5?key=Z8ZQgAb8&format=json&culture=en&p=0&ps=10")
    fun getCollections(): Call<List<Collections>>

    //Gets the collection details api
    @GET("/api/nl/collection/SK-C-5?key=Z8ZQgAb8&format=json&culture=en")
    fun getCollectionsDetails(): Call<List<CollectionsDetails>>
}