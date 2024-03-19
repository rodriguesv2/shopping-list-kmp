package com.jetbrains.kmpapp.presentation.screens.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.jetbrains.kmpapp.presentation.atomic.templates.ListTemplate
import com.jetbrains.kmpapp.presentation.dialogs.ErrorDialog

object ListScreen : Screen {
    @Composable
    override fun Content() {
        val screenModel: ListScreenModel = getScreenModel()
        val state by screenModel.state.collectAsState()

        LifecycleEffect(
            onStarted = {
                screenModel.load()
            }
        )

        state.errorMessage?.let { message ->
            ErrorDialog(
                text = message,
                onDismiss = screenModel::onDismissClick,
                onConfirmClick = screenModel::onDismissClick,
            )
        }
        ListTemplate(
            shoppingItems = state.items,
            loading = state.loading,
            snackbarHostState = state.snackbarHostState,
            onDeleteClick = screenModel::onDeleteClick,
            onItemClick = screenModel::onItemClick,
            onAddItemClick = screenModel::onAddItemClick,
        )
    }
}
