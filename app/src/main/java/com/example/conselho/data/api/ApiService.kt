package com.example.conselho.data.api

import com.example.conselho.data.model.AdviceResponse
import retrofit2.http.GET

interface ApiService {
    @GET("advice")
    suspend fun getAdvice(): AdviceResponse
}