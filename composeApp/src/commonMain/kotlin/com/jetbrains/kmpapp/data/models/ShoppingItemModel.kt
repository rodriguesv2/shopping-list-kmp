package com.jetbrains.kmpapp.data.models

import kotlinx.serialization.Serializable

@Serializable
data class ShoppingItemModel(
    val id: Long? = null,
    val name: String,
    val quantity: Int,
)