package com.jetbrains.kmpapp.presentation.screens.additem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.jetbrains.kmpapp.MR
import com.jetbrains.kmpapp.presentation.atomic.templates.EditItemFormTemplate
import com.jetbrains.kmpapp.presentation.dialogs.ErrorDialog
import dev.icerock.moko.resources.compose.stringResource

data object AddItemScreen : Screen {
    @Composable
    override fun Content() {
        val screenModel: AddItemScreenModel = getScreenModel()
        val state by screenModel.state.collectAsState()

        state.errorMessage?.let { message ->
            ErrorDialog(
                text = message,
                onDismiss = screenModel::onDismissClick,
                onConfirmClick = screenModel::onDismissClick,
            )
        }
        EditItemFormTemplate(
            title = stringResource(MR.strings.add_item_title),
            subtitle = stringResource(MR.strings.add_item_subtitle),
            buttonLabel = stringResource(MR.strings.add_item_create_button_label),
            nameValue = state.itemName,
            quantityValue = state.itemQuantity,
            isButtonEnabled = state.isButtonEnabled,
            isLoading = state.loading,
            snackbarHostState = state.snackbarHostState,
            onNameChange = screenModel::onNameChange,
            onQuantityChange = screenModel::onQuantityChange,
            onButtonClick = screenModel::onButtonClick,
            onListButtonClick = screenModel::onListButtonClick,
        )
    }
}