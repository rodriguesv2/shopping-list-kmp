package com.jetbrains.kmpapp

import androidx.compose.ui.uikit.ComposeUIViewControllerDelegate
import androidx.compose.ui.window.ComposeUIViewController
import com.jetbrains.kmpapp.utils.lifecycle.LifecycleRegistry
import com.jetbrains.kmpapp.utils.lifecycle.lifecycleCallBack

fun MainViewController() = ComposeUIViewController { App() }
