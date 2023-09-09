package com.example.cryptocurrency_app.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CoinDto(
    val id: String,
    val is_active: Boolean,
    @SerializedName("is_active")
    val is_new: Boolean,
    @SerializedName("is_new")
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)