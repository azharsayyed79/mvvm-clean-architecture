package com.azhar.cryptocurrencyappyt.domain.use_cases.get_coin

import com.azhar.cryptocurrencyappyt.common.Resource
import com.azhar.cryptocurrencyappyt.data.remote.dto.toCoinDetail
import com.azhar.cryptocurrencyappyt.domain.model.CoinDetail
import com.azhar.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("There is no internet connection"))
        }
    }

}