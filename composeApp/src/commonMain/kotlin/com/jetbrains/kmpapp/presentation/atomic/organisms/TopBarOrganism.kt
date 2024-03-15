package com.jetbrains.kmpapp.presentation.atomic.organisms

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun TopBarOrganism(
    title: String,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable (RowScope.() -> Unit) = {},
) {
    TopAppBar(
        title = { Text(text = title) },
        backgroundColor = Color(0xFF6750A4),
        contentColor = Color.White,
        navigationIcon = navigationIcon,
        actions = actions,
    )
}