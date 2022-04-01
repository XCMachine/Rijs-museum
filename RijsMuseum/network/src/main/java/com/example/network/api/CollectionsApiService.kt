package com.example.network.api

import com.example.network.resource.models.CollectionsDetailsResource
import com.example.network.resource.models.CollectionsResource
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CollectionsApiService {
    //Gets the collections api
    @GET("/api/{culture}/collection")
    fun getCollectionsList(
        @Path("culture") culture: String,
        @Query("format") format: String = "json",
        @Query("p") page: String = "0",
        @Query("ps") pages: String = "10",
        @Query("key") key: String = KEY
    ): Call<CollectionsResource>

    //GEts the collections details api
    @GET("/api/{culture}/collection/{objectNumber}")
    fun getCollectionsDetailsList(
        @Path("culture") culture: String,
        @Path("objectNumber") objectNumber: String,
        @Query("format") format: String,
        @Query("key") key: String = KEY
    ): Call<CollectionsDetailsResource>

    companion object {
        const val KEY = "Z8ZQgAb8"
    }
}