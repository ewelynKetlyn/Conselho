package com.example.conselho.domain.repository

import com.example.conselho.domain.model.Advice
import kotlinx.coroutines.flow.Flow

internal interface AdviceRepository {
    fun getAdvice(): Flow<Advice>
}