package com.jetbrains.kmpapp.presentation.screens.edititem

import androidx.compose.material.SnackbarDuration
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.jetbrains.kmpapp.domain.entities.ShoppingItem
import com.jetbrains.kmpapp.navigator
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EditItemScreenModel(
    private val item: ShoppingItem,
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
        //TODO
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

    fun onDismissClick() {
        mutableState.update { it.copy(errorMessage = null) }
    }

    private fun showSuccessSnack() {
        screenModelScope.launch {
            state.value.snackbarHostState.showSnackbar(
                message = "Item Atualizado com Sucesso!",
                duration = SnackbarDuration.Short,
            )
        }
    }
}