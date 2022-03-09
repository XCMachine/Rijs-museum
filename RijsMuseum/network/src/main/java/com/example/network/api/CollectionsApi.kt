package com.example.network.api

import com.example.network.models.Collections
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CollectionsApi {
    //Gets the collections api
    @GET("/api/{culture}/collection/SK-C-5?key=Z8ZQgAb8&format=json&culture=en&p=0&ps=10")
    fun getCollections(
        @Path("culture") culture: String,
        @Query("format") format: String = "json",
        @Query("p") p: String = "0",
        @Query("ps") ps: String = "10"
    ): Call<List<Collections>>
}