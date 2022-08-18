package com.example.conselho.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AdviceResponse (
    @SerializedName("slip")
    var slip: SlipResponse
):Parcelable