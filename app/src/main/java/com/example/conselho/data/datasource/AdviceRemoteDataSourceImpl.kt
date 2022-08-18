package com.example.conselho.data.datasource

import com.example.conselho.data.api.ApiService
import com.example.conselho.data.model.AdviceResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class AdviceRemoteDataSourceImpl(
    private val adviceService: ApiService
):AdviceRemoteDataSource {
    override fun getAdvice(): Flow<AdviceResponse> = flow {
        emit(adviceService.getAdvice())
    }
}