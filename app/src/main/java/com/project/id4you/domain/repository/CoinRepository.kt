package com.project.id4you.domain.repository

import com.project.id4you.data.remote.dto.CoinDetailDto
import com.project.id4you.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}