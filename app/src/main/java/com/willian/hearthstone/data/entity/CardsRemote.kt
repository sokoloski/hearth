package com.willian.hearthstone.data.entity

import com.squareup.moshi.Json
import com.willian.hearthstone.domain.entity.Card

data class CardsRemote(
    @field:Json(name = "Basic") val basic: List<CardRemote>,
    @field:Json(name = "Hall of Fame") val fame: List<CardRemote>,
    @field:Json(name = "Missions") val missions: List<CardRemote>
) {
    fun getCards(): List<Card> = (basic.map { it.transform() }.plus(fame.map { it.transform() })
        .plus(missions.map{ it.transform()}))
}
