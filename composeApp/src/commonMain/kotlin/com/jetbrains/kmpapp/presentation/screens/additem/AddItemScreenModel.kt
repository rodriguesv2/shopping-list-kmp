package com.jetbrains.kmpapp.presentation.screens.additem

import cafe.adriel.voyager.core.model.StateScreenModel
import com.jetbrains.kmpapp.data.MuseumRepository
import com.jetbrains.kmpapp.navigator
import com.jetbrains.kmpapp.presentation.screens.list.ListScreen
import kotlinx.coroutines.flow.update

class AddItemScreenModel(
//    museumRepository: MuseumRepository,
) : StateScreenModel<AddItemState>(AddItemState()) {
    init {
        setButtonState()
    }

    fun onNameChange(value: String) {
        mutableState.update {
            it.copy(itemName = value)
        }
        setButtonState()
    }

    fun onQuantityChange(value: String) {
        mutableState.update {
            it.copy(itemQuantity = value)
        }
        setButtonState()
    }

    fun onButtonClick() {
        //TODO("Not yet implemented")
    }

    fun onListButtonClick() {
        navigator.push(ListScreen)
    }

    private fun setButtonState() {
        val name = state.value.itemName
        val quantity = state.value.itemQuantity

        mutableState.update {
            it.copy(
                isButtonEnabled = name.isNotEmpty() && quantity.toIntOrNull() != null,
            )
        }
    }
//    val objects: StateFlow<List<MuseumObject>> =
//        museumRepository.getObjects()
//            .stateIn(screenModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
}
