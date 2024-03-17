package com.project.id4you.data.repository

import com.project.id4you.data.remote.dto.CoinDetailDto
import com.project.id4you.data.remote.dto.CoinDto
import com.project.id4you.data.remote.dto.CoinPaprikaApi
import com.project.id4you.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}