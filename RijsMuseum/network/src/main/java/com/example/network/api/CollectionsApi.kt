package com.example.network.api

import com.example.network.models.Collections
import com.example.network.models.CollectionsDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CollectionsApi {
    //Gets the collections api
    @GET("/api/{culture}/collection?key=Z8ZQgAb8&involvedMaker=Rembrandt+van+Rijn")
    fun getCollections(
        @Path("culture") culture: String,
        @Query("format") format: String = "json",
        @Query("p") page: String = "0",
        @Query("ps") pages: String = "10"
    ): Call<List<Collections>>

    //GEts the collections details api
    @GET("/api/{culture}/collection/SK-C-5?key=Z8ZQgAb8")
    fun getCollectionsDetails(
        @Path("culture") culture: String,
        @Query("format") format: String
    ): Call<List<CollectionsDetails>>
}