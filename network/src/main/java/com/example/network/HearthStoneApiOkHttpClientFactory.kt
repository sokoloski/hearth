package com.example.network

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.internal.userAgent
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class HearthStoneApiOkHttpClientFactory() : OkHttpClientFactory {

    override fun create(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(1000, TimeUnit.SECONDS)
            .readTimeout(1000, TimeUnit.SECONDS)
            .addInterceptor(getLoggingInterceptor())
            .build()
    }

    private fun getLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
        level = HttpLoggingInterceptor.Level.HEADERS

    }

    private fun Request.addUserContentToHeader(): Request {
        userAgent
        return newBuilder()
            .header("Content-Type", "application/json")
            .header("X-RapidAPI-Key", "717b8e8d91mshb1a43c84d5e0765p19c962jsn938e55cc7ee4")
            .method(this.method, this.body)
            .build()
    }
}
