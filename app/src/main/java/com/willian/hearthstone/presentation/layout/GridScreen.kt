package com.willian.hearthstone.presentation.layout

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.willian.hearthstone.domain.entity.Card
import com.willian.hearthstone.presentation.HearthStoneViewModel
import org.koin.androidx.compose.getViewModel

@ExperimentalFoundationApi
@ExperimentalCoilApi
@Composable
fun GridScreen(
    onCardClick: (Card) -> Unit
) {
    val viewModel = getViewModel<HearthStoneViewModel>()
    val state by viewModel.state.collectAsState()

    state?.listOfCards?.let {
        Column {
            LazyColumn(
                contentPadding = PaddingValues(8.dp)
            ) {
                items(it) {
                    Text(
                        modifier = Modifier
                            .clickable(enabled = true) {
                                onCardClick(it)
                            },
                        text = it.name
                    )
                    Image(
                        painter = rememberImagePainter(it.img),
                        contentDescription = null,
                        modifier = Modifier
                            .size(180.dp)
                            .padding(horizontal = 50.dp)
                    )
                }
            }
        }
    }
}
