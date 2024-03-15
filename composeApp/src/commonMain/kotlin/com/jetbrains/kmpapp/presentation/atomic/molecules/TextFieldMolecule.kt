package com.jetbrains.kmpapp.presentation.atomic.molecules

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun TextFieldMolecule(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    type: FieldType = FieldType.TEXT,
    maxLength: Int = Int.MAX_VALUE,
) {
    OutlinedTextField(
        modifier = modifier,
        label = {
            Text(text = label)
        },
        value = value,
        onValueChange = callback@{
            val isValueOnlyNumeric = NUMERIC_REGEX.toRegex().matches(it)
            if (type == FieldType.NUMERIC && !isValueOnlyNumeric) return@callback

            onValueChange(it.take(maxLength))
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = when (type) {
                FieldType.NUMERIC -> KeyboardType.Number
                FieldType.TEXT -> KeyboardType.Text
            }
        )
    )
}

enum class FieldType {
    NUMERIC, TEXT
}

const val NUMERIC_REGEX = "([\\d.,]*)"