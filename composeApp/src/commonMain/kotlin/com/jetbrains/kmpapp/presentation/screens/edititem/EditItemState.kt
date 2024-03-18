package com.jetbrains.kmpapp.presentation.screens.edititem

data class EditItemState(
    val loading: Boolean = false,
    val errorMessage: String? = null,
    val itemName: String = "",
    val itemQuantity: String = "1",
    val isButtonEnabled: Boolean = true,
)