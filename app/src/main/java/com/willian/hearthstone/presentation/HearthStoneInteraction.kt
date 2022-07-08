package com.willian.hearthstone.presentation

import com.willian.hearthstone.domain.entity.Card

sealed class HearthStoneInteraction {
    object Open : HearthStoneInteraction()
    data class LoadCard(val cards: List<Card>) : HearthStoneInteraction()
    data class SearchCard(val search: String) : HearthStoneInteraction()
}
