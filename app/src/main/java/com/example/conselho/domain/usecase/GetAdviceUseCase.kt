package com.example.conselho.domain.usecase

import com.example.conselho.domain.model.Advice
import com.example.conselho.domain.repository.AdviceRepository
import kotlinx.coroutines.flow.Flow

internal class GetAdviceUseCase(
    private val adviceRepository: AdviceRepository
) {
    operator fun invoke(): Flow<Advice> {
        return adviceRepository.getAdvice()
    }
}