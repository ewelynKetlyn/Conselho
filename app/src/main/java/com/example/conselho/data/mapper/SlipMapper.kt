package com.example.conselho.data.mapper

import com.example.conselho.data.model.SlipResponse
import com.example.conselho.domain.model.Slip

internal class SlipMapper {
    fun map(slipResponse: SlipResponse) = Slip(
        id = slipResponse.id,
        advice = slipResponse.advice
    )
}