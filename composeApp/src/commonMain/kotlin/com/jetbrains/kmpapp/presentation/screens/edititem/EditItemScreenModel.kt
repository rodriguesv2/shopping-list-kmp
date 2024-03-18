package com.jetbrains.kmpapp.presentation.screens.edititem

import cafe.adriel.voyager.core.model.StateScreenModel
import com.jetbrains.kmpapp.domain.entities.ShoppingItem
import com.jetbrains.kmpapp.navigator
import kotlinx.coroutines.flow.update

class EditItemScreenModel(
    item: ShoppingItem,
) : StateScreenModel<EditItemState>(
    EditItemState(
        itemName = item.title,
        itemQuantity = item.quantity,
    ),
) {
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

    private fun setButtonState() {
        val name = state.value.itemName
        val quantity = state.value.itemQuantity

        mutableState.update {
            it.copy(
                isButtonEnabled = name.isNotEmpty() && quantity.toIntOrNull() != null,
            )
        }
    }

    fun onBackButtonClick() {
        navigator.pop()
    }

}