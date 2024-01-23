package com.azhar.cryptocurrencyappyt.domain.use_cases.get_coins

import com.azhar.cryptocurrencyappyt.common.Resource
import com.azhar.cryptocurrencyappyt.data.remote.dto.toCoin
import com.azhar.cryptocurrencyappyt.domain.model.Coin
import com.azhar.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("There is no internet connection"))
        }
    }

}