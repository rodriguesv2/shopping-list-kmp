package com.jetbrains.kmpapp.previews

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jetbrains.kmpapp.presentation.dialogs.ErrorDialog

@Preview
@Composable
private fun SuccessPreview() {
    Surface(Modifier.fillMaxSize()) {
        ErrorDialog(
            text = "Erro Desconhecido",
            onDismiss = {},
            onConfirmClick = {}
        )
    }
}