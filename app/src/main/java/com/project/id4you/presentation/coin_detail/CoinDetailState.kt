package com.project.id4you.presentation.coin_detail

import com.project.id4you.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)