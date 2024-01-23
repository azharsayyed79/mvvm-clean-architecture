package com.azhar.cryptocurrencyappyt.data.repository

import com.azhar.cryptocurrencyappyt.data.remote.CoinPaprikaApi
import com.azhar.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.azhar.cryptocurrencyappyt.data.remote.dto.CoinDto
import com.azhar.cryptocurrencyappyt.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
):CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
       return api.getCoinById(coinId)
    }
}