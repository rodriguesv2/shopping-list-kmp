package com.jetbrains.kmpapp.presentation.dialogs

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.DialogProperties

@Composable
fun ErrorDialog(
    text: String,
    onDismiss: () -> Unit,
    onConfirmClick: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(
                onClick = onConfirmClick,
                content = {
                    Text("OK")
                }
            )
        },
        title = {
            Text("Erro!")
        },
        text = {
            Text(text)
        },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false,
        )
    )
}