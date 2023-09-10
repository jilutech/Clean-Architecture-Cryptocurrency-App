package com.example.cryptocurrency_app.domain.use_case.get_coin

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.cryptocurrency_app.common.Resource
import com.example.cryptocurrency_app.data.remote.dto.toCoinDetails
import com.example.cryptocurrency_app.domain.model.Coin
import com.example.cryptocurrency_app.domain.model.CoinDetails
import com.example.cryptocurrency_app.domain.model.toCoin
import com.example.cryptocurrency_app.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.HTTP
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository
){

    operator fun invoke(coinId : String) : Flow<Resource<CoinDetails>> = flow {
        try {

            emit(Resource.Loading())
            val coins = coinRepository.getCoinByID(coinId).toCoinDetails()
            emit(Resource.Success(coins))

        } catch (e : retrofit2.HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An UnExpected Error"))
        } catch (e : IOException){
            emit(Resource.Error("Could not reach Server,Check Connection"))
        }
    }

}