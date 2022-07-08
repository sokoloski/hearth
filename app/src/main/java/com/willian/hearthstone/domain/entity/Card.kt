package com.willian.hearthstone.domain.entity

data class Card(
    val cardId: String,
    val name: String,
    val cardSet: String,
    val type: String,
    val faction: String,
    val rarity: String,
    val text: String,
    val img: String,
    val locale: String,
    val photo: String
)
