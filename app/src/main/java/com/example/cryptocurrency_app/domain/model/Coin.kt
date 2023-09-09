package com.example.cryptocurrency_app.domain.model

import com.example.cryptocurrency_app.data.remote.dto.CoinDto
import com.google.gson.annotations.SerializedName

data class Coin(
    val id: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
    )
// function to map the dto
fun CoinDto.toCoin() : Coin{
    return Coin(
        id = id,
        is_active = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )
}