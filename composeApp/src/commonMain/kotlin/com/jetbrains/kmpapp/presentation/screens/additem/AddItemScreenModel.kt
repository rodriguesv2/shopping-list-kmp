package com.jetbrains.kmpapp.presentation.screens.additem

import androidx.compose.material.SnackbarDuration
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.jetbrains.kmpapp.domain.entities.ShoppingItem
import com.jetbrains.kmpapp.domain.repositories.ShoppingRepository
import com.jetbrains.kmpapp.navigator
import com.jetbrains.kmpapp.utils.extensions.launchRequest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AddItemScreenModel(
    private val repository: ShoppingRepository
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
        val shoppingItem = state.value.run {
            ShoppingItem(
                title = itemName,
                quantity = itemQuantity,
            )
        }

        screenModelScope.launchRequest(
            block = { repository.createItem(shoppingItem) },
            onLoading = { loading -> mutableState.update { it.copy(loading = loading) } },
            onSuccess = {
                showSuccessSnack()
                mutableState.update {
                    it.copy(
                        itemName = "",
                        itemQuantity = "1"
                    )
                }
            },
            onError = { mutableState.update { it.copy(errorMessage = "Erro Desconhecido") } }
        )
    }

    fun onDismissClick() {
        mutableState.update { it.copy(errorMessage = null) }
    }

    fun onBackButtonClick() {
        navigator.pop()
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

    private fun showSuccessSnack() {
        screenModelScope.launch {
            state.value.snackbarHostState.showSnackbar(
                message = "Item Adicionado com Sucesso!",
                duration = SnackbarDuration.Short,
            )
        }
    }
}
