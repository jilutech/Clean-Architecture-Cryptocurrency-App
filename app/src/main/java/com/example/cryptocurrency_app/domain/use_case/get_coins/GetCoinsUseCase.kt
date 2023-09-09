package com.example.cryptocurrency_app.domain.use_case.get_coins

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.cryptocurrency_app.common.Resource
import com.example.cryptocurrency_app.data.remote.dto.CoinPaprikaApi
import com.example.cryptocurrency_app.domain.model.Coin
import com.example.cryptocurrency_app.domain.model.toCoin
import com.example.cryptocurrency_app.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
){


    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        try {

            emit(Resource.Loading())

            val coins = coinRepository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))

        } catch (e : HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An UnExpected Error"))
        } catch (e : IOException){
            emit(Resource.Error("Could not reach Server,Check Connection"))
        }
    }

}