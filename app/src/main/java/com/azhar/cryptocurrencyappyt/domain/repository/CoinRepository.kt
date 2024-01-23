package com.azhar.cryptocurrencyappyt.domain.repository

import com.azhar.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.azhar.cryptocurrencyappyt.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins():List<CoinDto>
    suspend fun getCoinById(coinId: String):CoinDetailDto
}