package com.willian.hearthstone.domain.repository

import com.willian.hearthstone.domain.entity.Card

interface HearthStoneRepository {
    suspend fun getCards(): List<Card>
}
