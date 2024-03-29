package com.jetbrains.kmpapp.presentation.atomic.molecules

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Composable
fun ButtonMolecule(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    loading: Boolean = false,
) {
    Button(
        modifier = modifier.height(55.dp),
        content = content@{
            if (loading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(32.dp),
                    color = Color.White,
                )
                return@content
            }
            Text(text = label.uppercase())
        },
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            backgroundColor = Color(0xFF6750A4)
        ),
        shape = RoundedCornerShape(30.dp),
        enabled = isEnabled,
    )
}