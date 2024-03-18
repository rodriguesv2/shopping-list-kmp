package com.jetbrains.kmpapp

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.jetbrains.kmpapp.presentation.screens.additem.AddItemScreen

@Composable
fun App() {
    MaterialTheme {
        Navigator(AddItemScreen) { navigator ->
            saveAppNavigator(navigator)

            val currentScreen = navigator.lastItem

            navigator.saveableState("currentScreen") {
                currentScreen.Content()
            }
        }
    }
}
