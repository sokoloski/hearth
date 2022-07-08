package com.willian.hearthstone.data.entity

import com.squareup.moshi.Json
import com.willian.hearthstone.domain.entity.Card

data class CardRemote(
    @field:Json(name = "cardId") val id: String?,
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "cardSet") val cardSet: String?,
    @field:Json(name = "type") val type: String?,
    @field:Json(name = "faction") val faction: String?,
    @field:Json(name = "rarity") val rarity: String?,
    @field:Json(name = "text") val text: String?,
    @field:Json(name = "img") val img: String?,
    @field:Json(name = "locale") val locale: String?,
    @field:Json(name = "photo") val photo: String?
) {
    fun transform() = Card(
        cardId = id ?: "",
        name = name ?: "",
        cardSet = cardSet ?: "",
        type = type ?: "",
        faction = faction ?: "",
        rarity = rarity ?: "",
        text = text ?: "",
        img = img ?: "",
        locale = locale ?: "",
        photo = photo ?: ""
    )
}
