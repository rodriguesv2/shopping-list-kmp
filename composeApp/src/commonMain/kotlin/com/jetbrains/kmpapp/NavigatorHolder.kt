package com.jetbrains.kmpapp

import cafe.adriel.voyager.navigator.Navigator

private var appNavigator: Navigator? = null

fun saveAppNavigator(navigator: Navigator) {
    appNavigator = navigator
}

val navigator: Navigator
    get() {
        if (appNavigator == null) throw NoSuchElementException("Navigator is not set")
        return appNavigator!!
    }