package com.willian.hearthstone.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.willian.hearthstone.domain.entity.Card
import com.willian.hearthstone.domain.repository.HearthStoneRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HearthStoneViewModel(
    private val repository: HearthStoneRepository
) : ViewModel() {

    private val cards = MutableLiveData<List<Card>>()
    var job: Job? = null

    private val _state = MutableStateFlow<HearthStoneState?>(HearthStoneState(true))
    val state: StateFlow<HearthStoneState?> get() = _state

    fun interact(interaction: HearthStoneInteraction) {
        when (interaction) {
            is HearthStoneInteraction.Open -> {
                fetchCardsResult()
            }
            is HearthStoneInteraction.LoadCard -> {
                //fetchFlickerPhotos(interaction.cards)
            }
            is HearthStoneInteraction.SearchCard-> {
                fetchResult()
            }
        }
    }

    private fun fetchResult() {
        viewModelScope.launch {
            _state.value = HearthStoneState(false, listOf(), true)
        }
    }

    private fun fetchCardsResult() {
        viewModelScope.launch {
            job?.cancel()
            cards.value = repository.getCards()
            cards.value.let {
                _state.value = it?.let { cards -> HearthStoneState(false, cards) }
            }
        }
    }
}
