package com.project.id4you.presentation.coin_list

import com.project.id4you.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)