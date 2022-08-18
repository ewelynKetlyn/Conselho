package com.example.conselho.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.adviceslip.com/"

//Instancia retrofit
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(OkHttpClient.Builder().build())
    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()




