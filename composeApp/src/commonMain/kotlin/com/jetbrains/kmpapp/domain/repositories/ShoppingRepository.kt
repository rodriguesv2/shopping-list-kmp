package com.jetbrains.kmpapp.domain.repositories

import com.jetbrains.kmpapp.domain.entities.ShoppingItem

interface ShoppingRepository {
    suspend fun createItem(item: ShoppingItem)
    suspend fun getItems(): List<ShoppingItem>
    suspend fun deleteItem(id: String)
    suspend fun updateItem(item: ShoppingItem)
}