package com.jetbrains.kmpapp.data.repositories

import com.jetbrains.kmpapp.data.datasources.ShoppingDatasource
import com.jetbrains.kmpapp.domain.entities.ShoppingItem
import com.jetbrains.kmpapp.domain.mappers.toShoppingItemEntity
import com.jetbrains.kmpapp.domain.mappers.toShoppingItemModel
import com.jetbrains.kmpapp.domain.repositories.ShoppingRepository

class ShoppingRepositoryRemote(
    private val datasource: ShoppingDatasource,
): ShoppingRepository {
    override suspend fun createItem(item: ShoppingItem) {
        datasource.createItem(item.toShoppingItemModel())
    }

    override suspend fun getItems(): List<ShoppingItem> =
        datasource
            .getItems()
            .map { it.toShoppingItemEntity() }

    override suspend fun deleteItem(id: String) {
        datasource.deleteItem(id.toLong())
    }

    override suspend fun updateItem(item: ShoppingItem) {
        datasource.updateItem(item.toShoppingItemModel())
    }
}