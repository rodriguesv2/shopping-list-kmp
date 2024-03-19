package com.jetbrains.kmpapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jetbrains.kmpapp.domain.entities.ShoppingItem
import com.jetbrains.kmpapp.presentation.atomic.templates.EditItemFormTemplate
import com.jetbrains.kmpapp.presentation.atomic.templates.ListTemplate
import com.jetbrains.kmpapp.presentation.atomic.templates.LoadingFullScreen
import kotlin.random.Random

@Preview
@Composable
private fun LoadingPreview() {
    LoadingFullScreen()
}

@Preview
@Composable
private fun EditItemFormPreview() {
    EditItemFormTemplate(
        title = "Adicionar Item",
        subtitle = "Adicione Item",
        nameValue = "",
        quantityValue = "",
        onNameChange = {},
        onQuantityChange = {},
        buttonLabel = "Criar",
        onButtonClick = {},
        onBackButtonClick = {}
    )
}

@Preview
@Composable
private fun ListPreview() {
    ListTemplate(
        shoppingItems = List(20) {
            ShoppingItem(
                id = it.toString(),
                title = "Item #$it",
                quantity = Random.nextInt(
                    from = 1,
                    until = 99,
                ).toString()
            )
        },
        onDeleteClick = {},
        onItemClick = {},
       onAddItemClick = {}
    )
}

@Preview
@Composable
private fun ListEmptyPreview() {
    ListTemplate(
        shoppingItems = emptyList(),
        onDeleteClick = {},
        onItemClick = {},
        onAddItemClick = {},
    )
}

@Preview
@Composable
private fun ListLoadingPreview() {
    ListTemplate(
        shoppingItems = emptyList(),
        onDeleteClick = {},
        onItemClick = {},
        onAddItemClick = {},
        loading = true
    )
}

