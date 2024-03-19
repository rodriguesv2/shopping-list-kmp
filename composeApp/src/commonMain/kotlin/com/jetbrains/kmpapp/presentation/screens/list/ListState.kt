package com.jetbrains.kmpapp.presentation.screens.list

import androidx.compose.material.SnackbarHostState
import com.jetbrains.kmpapp.domain.entities.ShoppingItem

data class ListState(
    val loading: Boolean = false,
    val errorMessage: String? = null,
    val items: List<ShoppingItem> = emptyList(),
    val snackbarHostState: SnackbarHostState = SnackbarHostState(),
)