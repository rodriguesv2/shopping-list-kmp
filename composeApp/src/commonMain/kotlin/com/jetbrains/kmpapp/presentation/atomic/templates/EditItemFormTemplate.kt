package com.jetbrains.kmpapp.presentation.atomic.templates

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetbrains.kmpapp.MR
import com.jetbrains.kmpapp.presentation.atomic.atoms.IconButtonAtom
import com.jetbrains.kmpapp.presentation.atomic.molecules.ButtonMolecule
import com.jetbrains.kmpapp.presentation.atomic.molecules.FieldType
import com.jetbrains.kmpapp.presentation.atomic.molecules.TextFieldMolecule
import com.jetbrains.kmpapp.presentation.atomic.organisms.TopBarOrganism
import com.jetbrains.kmpapp.presentation.components.SpacerExpanded
import com.jetbrains.kmpapp.presentation.components.SpacerPadding
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun EditItemFormTemplate(
    title: String,
    subtitle: String,
    nameValue: String,
    quantityValue: String,
    buttonLabel: String,
    onNameChange: (String) -> Unit,
    onQuantityChange: (String) -> Unit,
    onButtonClick: () -> Unit,
    onBackButtonClick: (() -> Unit)? = null,
    onListButtonClick: (() -> Unit)? = null,
    isButtonEnabled: Boolean = true,
    isLoading: Boolean = false,
) {
    Scaffold(
        topBar = {
            TopBarOrganism(
                title = title,
                navigationIcon = if (onBackButtonClick != null) {
                    {
                        IconButtonAtom(
                            painter = painterResource(imageResource = MR.images.ic_back_arrow),
                            onClick = onBackButtonClick,
                        )
                    }
                } else null,
                actions = {
                    onListButtonClick?.let { callback ->
                        IconButtonAtom(
                            painter = painterResource(imageResource = MR.images.ic_list),
                            onClick = callback
                        )
                    }
                }
            )
        }
    ) {
        Column(
            Modifier
                .padding(it)
                .padding(16.dp),
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = subtitle,
                fontSize = 16.sp,
            )
            SpacerPadding()
            TextFieldMolecule(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(MR.strings.add_item_name_text_field_label),
                value = nameValue,
                onValueChange = onNameChange
            )
            SpacerPadding()
            TextFieldMolecule(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(MR.strings.add_item_quantity_text_field_label),
                value = quantityValue,
                onValueChange = onQuantityChange,
                type = FieldType.NUMERIC,
                maxLength = 3,
            )
            SpacerExpanded()
            ButtonMolecule(
                modifier = Modifier.fillMaxWidth(),
                label = buttonLabel,
                onClick = onButtonClick,
                isEnabled = isButtonEnabled,
                loading = isLoading,
            )
        }
    }
}