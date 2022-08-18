package com.example.conselho.data.repository

import com.example.conselho.data.datasource.AdviceRemoteDataSource
import com.example.conselho.data.mapper.AdviceMapper
import com.example.conselho.domain.model.Advice
import com.example.conselho.domain.repository.AdviceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class AdviceRepositoryImpl(
    private val adviceRemoteDataSource: AdviceRemoteDataSource,
    private val adviceMapper: AdviceMapper
): AdviceRepository {
    override fun getAdvice(): Flow<Advice> =
        adviceRemoteDataSource
            .getAdvice()
            .map(adviceMapper::map)
}