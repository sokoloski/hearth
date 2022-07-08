package com.willian.hearthstone.data.repository

import com.willian.hearthstone.data.service.HearthStoneService
import com.willian.hearthstone.domain.entity.Card
import com.willian.hearthstone.domain.repository.HearthStoneRepository

class HearthStoneRepositoryImpl(
    private val HearthStoneService: HearthStoneService
) : HearthStoneRepository {
    override suspend fun getCards(): List<Card> {
        return HearthStoneService.getCards("717b8e8d91mshb1a43c84d5e0765p19c962jsn938e55cc7ee4").getCards()
    }
}
