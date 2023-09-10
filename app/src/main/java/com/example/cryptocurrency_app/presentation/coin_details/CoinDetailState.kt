package com.example.cryptocurrency_app.presentation.coin_details

import com.example.cryptocurrency_app.domain.model.Coin
import com.example.cryptocurrency_app.domain.model.CoinDetails

data class CoinDetailState(
    val isLoading : Boolean = false,
    val coin : CoinDetails ? = null,
    val error : String = ""
)