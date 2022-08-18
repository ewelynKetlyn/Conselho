package com.example.conselho.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SlipResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("advice")
    val advice:String
):Parcelable

