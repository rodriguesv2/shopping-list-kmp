package com.jetbrains.kmpapp.presentation.atomic.organisms

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.jetbrains.kmpapp.MR
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun EmptyListOrganism() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = stringResource(MR.strings.list_item_empty),
            fontSize = 20.sp,
            color = Color.Gray,
        )
    }
}