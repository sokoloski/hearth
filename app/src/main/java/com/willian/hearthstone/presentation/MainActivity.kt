package com.willian.hearthstone.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import coil.annotation.ExperimentalCoilApi
import com.willian.hearthstone.presentation.di.injectHearthStoneKoinModule
import com.willian.hearthstone.presentation.di.injectNetWorkKoinModule
import com.willian.hearthstone.presentation.layout.GridScreen
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.GlobalContext.startKoin

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<HearthStoneViewModel>()

    @OptIn(ExperimentalFoundationApi::class, ExperimentalCoilApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            applicationContext
        }

        injectNetWorkKoinModule()
        injectHearthStoneKoinModule()

        viewModel.interact(HearthStoneInteraction.Open)
        setContent {
            GridScreen(
                onCardClick = {}
            )
        }
    }
}
