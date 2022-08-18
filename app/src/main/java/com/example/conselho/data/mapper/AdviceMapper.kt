package com.example.conselho.data.mapper

import com.example.conselho.data.model.AdviceResponse
import com.example.conselho.domain.model.Advice

internal class AdviceMapper {
    fun map(adviceResponse: AdviceResponse) = Advice(
        slip = SlipMapper().map(adviceResponse.slip)
    )
}