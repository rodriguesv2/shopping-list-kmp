package com.jetbrains.kmpapp.presentation.screens.list

import androidx.compose.material.SnackbarDuration
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.jetbrains.kmpapp.domain.entities.ShoppingItem
import com.jetbrains.kmpapp.navigator
import com.jetbrains.kmpapp.presentation.screens.additem.AddItemScreen
import com.jetbrains.kmpapp.presentation.screens.edititem.EditItemScreen
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ListScreenModel: StateScreenModel<ListState>(ListState()) {

    fun load() {
        //TODO
    }

    fun onDeleteClick(shoppingItem: ShoppingItem) {
        //TODO
    }

    fun onItemClick(shoppingItem: ShoppingItem) {
        navigator.push(EditItemScreen(shoppingItem))
    }

    fun onAddItemClick() {
        navigator.push(AddItemScreen)
    }

    fun onDismissClick() {
        mutableState.update { it.copy(errorMessage = null) }
    }

    private fun showSuccessSnack() {
        screenModelScope.launch {
            state.value.snackbarHostState.showSnackbar(
                message = "Item Excluido com Sucesso!",
                duration = SnackbarDuration.Short,
            )
        }
    }
}
