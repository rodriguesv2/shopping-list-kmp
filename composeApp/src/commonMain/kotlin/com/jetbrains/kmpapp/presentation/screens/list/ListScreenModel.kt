package com.jetbrains.kmpapp.presentation.screens.list

import androidx.compose.material.SnackbarDuration
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.jetbrains.kmpapp.data.MuseumObject
import com.jetbrains.kmpapp.data.MuseumRepository
import com.jetbrains.kmpapp.domain.entities.ShoppingItem
import com.jetbrains.kmpapp.domain.repositories.ShoppingRepository
import com.jetbrains.kmpapp.navigator
import com.jetbrains.kmpapp.presentation.screens.edititem.EditItemScreen
import com.jetbrains.kmpapp.utils.extensions.launchRequest
import io.ktor.client.plugins.ClientRequestException
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ListScreenModel(
    private val repository: ShoppingRepository
) : StateScreenModel<ListState>(ListState()) {

    fun load() {
        screenModelScope.launchRequest(
            block = { repository.getItems() },
            onLoading = { loading -> mutableState.update { it.copy(loading = loading) } },
            onSuccess = { items -> mutableState.update { it.copy(items = items) } },
            onError = { mutableState.update { it.copy(errorMessage = "Erro Desconhecido!") } }
        )
    }

    fun onDeleteClick(shoppingItem: ShoppingItem) {
        screenModelScope.launchRequest(
            block = { repository.deleteItem(shoppingItem.id ?: "") },
            onLoading = { loading -> mutableState.update { it.copy(loading = loading) } },
            onSuccess = {
                showSuccessSnack()
                mutableState.update {
                    it.copy(
                        items = state
                            .value
                            .items
                            .toMutableList()
                            .apply { remove(shoppingItem) }
                    )
                }
            },
            onError = { error ->
                mutableState.update {
                    it.copy(
                        errorMessage =
                        if ((error as ClientRequestException).response.status == HttpStatusCode.NotFound)
                            "Item não encontrado para exclusão!"
                        else
                            "Erro Desconhecido",
                    )
                }
            }
        )
    }

    fun onItemClick(shoppingItem: ShoppingItem) {
        navigator.push(EditItemScreen(shoppingItem))
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
                message = "Item Excluido com Sucesso!",
                duration = SnackbarDuration.Short,
            )
        }
    }
}
