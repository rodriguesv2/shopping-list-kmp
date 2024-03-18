package com.jetbrains.kmpapp.presentation.screens.edititem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.jetbrains.kmpapp.MR
import com.jetbrains.kmpapp.domain.entities.ShoppingItem
import com.jetbrains.kmpapp.presentation.atomic.templates.EditItemFormTemplate
import dev.icerock.moko.resources.compose.stringResource
import org.koin.core.parameter.ParametersHolder

class EditItemScreen(private val item: ShoppingItem): Screen{

    @Composable
    override fun Content() {
        val screenModel: EditItemScreenModel = getScreenModel(
            parameters = {
                ParametersHolder(
                    mutableListOf(item)
                )
            }
        )
        val state by screenModel.state.collectAsState()

        EditItemFormTemplate(
            title = stringResource(MR.strings.edit_item_title),
            subtitle = stringResource(MR.strings.edit_item_subtitle),
            buttonLabel = stringResource(MR.strings.edit_item_save_button),
            nameValue = state.itemName,
            quantityValue = state.itemQuantity,
            isButtonEnabled = state.isButtonEnabled,
            isLoading = state.loading,
            onNameChange = screenModel::onNameChange,
            onQuantityChange = screenModel::onQuantityChange,
            onButtonClick = screenModel::onButtonClick,
            onBackButtonClick = screenModel::onBackButtonClick,
        )
    }
}