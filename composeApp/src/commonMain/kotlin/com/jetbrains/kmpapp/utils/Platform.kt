package com.jetbrains.kmpapp.utils

expect fun getPlatform(): Platform

enum class Platform {
    ANDROID, IOS
}