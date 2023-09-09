package com.example.cryptocurrency_app.domain.repository

import com.example.cryptocurrency_app.data.remote.dto.CoinDetailDto
import com.example.cryptocurrency_app.data.remote.dto.CoinDto
import com.example.cryptocurrency_app.domain.model.Coin
import com.example.cryptocurrency_app.domain.model.CoinDetails

interface CoinRepository {

//    here we need to define the function
//    if we want cache or db we can define here
//

    suspend fun getCoins()  : List<CoinDto>

    suspend fun getCoinByID(coinId : String) : CoinDetailDto
}