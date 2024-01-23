package com.azhar.cryptocurrencyappyt.presentation.ui.coin_list

import com.azhar.cryptocurrencyappyt.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
