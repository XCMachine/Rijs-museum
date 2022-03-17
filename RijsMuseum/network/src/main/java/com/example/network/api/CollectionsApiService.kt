package com.example.network.api

import com.example.network.models.Collections
import com.example.network.models.CollectionsDetails
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
    ): Call<Collections>

    //GEts the collections details api
    @GET("/api/{culture}/collection/{objectNumber}")
    fun getCollectionsDetailsList(
        @Path("culture") culture: String,
        @Path("objectNumber") objectNumber: String,
        @Query("format") format: String,
        @Query("key") key: String = KEY
    ): Call<CollectionsDetails>

    companion object {
        const val KEY = "Z8ZQgAb8"
    }
}