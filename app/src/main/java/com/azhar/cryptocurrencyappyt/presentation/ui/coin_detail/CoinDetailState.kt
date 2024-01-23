package com.azhar.cryptocurrencyappyt.presentation.ui.coin_detail

import com.azhar.cryptocurrencyappyt.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
