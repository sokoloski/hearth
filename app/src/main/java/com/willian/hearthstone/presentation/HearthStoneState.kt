package com.willian.hearthstone.presentation

import com.willian.hearthstone.domain.entity.Card

data class HearthStoneState(
    val loading: Boolean = false,
    val listOfCards: List<Card> = listOf(),
    val openNewCard: Boolean = false
)
