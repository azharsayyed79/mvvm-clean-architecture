package com.azhar.cryptocurrencyappyt.data.remote

import com.azhar.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.azhar.cryptocurrencyappyt.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins():List<CoinDto>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinID") coinId: String): CoinDetailDto


}