package com.jetbrains.kmpapp.presentation.screens.additem

data class AddItemState(
    val loading: Boolean = false,
    val errorMessage: String? = null,
    val itemName: String = "",
    val itemQuantity: String = "1",
    val isButtonEnabled: Boolean = true,
)