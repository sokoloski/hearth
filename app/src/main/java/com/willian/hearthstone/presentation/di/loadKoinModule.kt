package com.willian.hearthstone.presentation.di

import com.example.network.*
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectNetWorkKoinModule() = loadKoinModule

private val loadKoinModule by lazy {
    loadKoinModules(
        module {
            factory<OkHttpClientFactory> {
                HearthStoneApiOkHttpClientFactory()
            }
            single { ApiServiceFactory(get(), get()) }

            single<ApiUrl> {
                HearthStoneApiUrl()
            }
        }
    )
}
