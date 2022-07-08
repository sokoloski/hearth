package com.willian.hearthstone.presentation.di

import com.example.network.ApiServiceFactory
import com.willian.hearthstone.data.repository.HearthStoneRepositoryImpl
import com.willian.hearthstone.data.service.HearthStoneService
import com.willian.hearthstone.domain.repository.HearthStoneRepository
import com.willian.hearthstone.presentation.HearthStoneViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectHearthStoneKoinModule() {
    lazyLoadKoinModule
}

private val lazyLoadKoinModule by lazy {
    loadKoinModules(
        listOf(
            repositoryModule,
            viewModelModule,
            serviceModule
        )
    )
}

private val repositoryModule = module {
    single<HearthStoneRepository> { HearthStoneRepositoryImpl(get()) }
}

private val viewModelModule = module {
    viewModel { HearthStoneViewModel(get()) }
}

private val serviceModule = module {
    single { get<ApiServiceFactory>().create(HearthStoneService::class.java) }
}
