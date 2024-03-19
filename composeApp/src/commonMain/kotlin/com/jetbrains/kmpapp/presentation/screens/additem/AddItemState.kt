package com.jetbrains.kmpapp.presentation.screens.additem

import androidx.compose.material.SnackbarHostState

data class AddItemState(
    val loading: Boolean = false,
    val errorMessage: String? = null,
    val itemName: String = "",
    val itemQuantity: String = "1",
    val isButtonEnabled: Boolean = true,
    val snackbarHostState: SnackbarHostState = SnackbarHostState()
)