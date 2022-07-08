package com.willian.hearthstone.data.service

import com.willian.hearthstone.data.entity.CardsRemote
import retrofit2.http.GET
import retrofit2.http.Header

interface HearthStoneService {
    @GET("cards")
    suspend fun getCards(@Header("X-RapidAPI-Key") key: String): CardsRemote
}
