package com.example.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {
    private val interceptor = HttpLoggingInterceptor()
    private val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    val builder: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    companion object {
        const val baseUrl = "https://www.rijksmuseum.nl"
    }
}