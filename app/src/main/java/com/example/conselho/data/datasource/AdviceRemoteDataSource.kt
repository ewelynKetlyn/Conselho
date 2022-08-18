package com.example.conselho.data.datasource

import com.example.conselho.data.model.AdviceResponse
import kotlinx.coroutines.flow.Flow

internal interface AdviceRemoteDataSource {
    fun getAdvice(): Flow<AdviceResponse>
}