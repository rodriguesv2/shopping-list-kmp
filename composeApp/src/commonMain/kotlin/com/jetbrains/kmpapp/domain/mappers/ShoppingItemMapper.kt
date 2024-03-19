package com.jetbrains.kmpapp.domain.mappers

import com.jetbrains.kmpapp.data.models.ShoppingItemModel
import com.jetbrains.kmpapp.domain.entities.ShoppingItem

fun ShoppingItem.toShoppingItemModel() = ShoppingItemModel(
    id = this.id?.toLong(),
    name = this.title,
    quantity = this.quantity.toInt(),
)

fun ShoppingItemModel.toShoppingItemEntity() = ShoppingItem(
    id = this.id?.toString() ?: "",
    title = this.name,
    quantity = quantity.toString(),
)