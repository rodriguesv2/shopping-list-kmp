package com.jetbrains.kmpapp.presentation.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ColumnScope.SpacerPadding(padding: Dp = 16.dp) {
    Spacer(modifier = Modifier.height(padding))
}

@Composable
fun RowScope.SpacerPadding(padding: Dp = 16.dp) {
    Spacer(modifier = Modifier.width(padding))
}

@Composable
fun ColumnScope.SpacerExpanded(weight: Float = 1f) {
    Spacer(modifier = Modifier.weight(weight))
}

@Composable
fun RowScope.SpacerExpanded(weight: Float = 1f) {
    Spacer(modifier = Modifier.weight(weight))
}