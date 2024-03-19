package com.jetbrains.kmpapp.data.datasources

import com.jetbrains.kmpapp.data.models.ShoppingItemModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody

interface ShoppingDatasource {
    suspend fun createItem(item: ShoppingItemModel)
    suspend fun getItems(): List<ShoppingItemModel>
    suspend fun deleteItem(id: Long)
    suspend fun updateItem(item: ShoppingItemModel)
}

class ShoppingDatasourceImpl(
    private val client: HttpClient
) : ShoppingDatasource {
    override suspend fun createItem(item: ShoppingItemModel) {
        client.post("/shopping/item") { setBody(item) }
    }

    override suspend fun getItems(): List<ShoppingItemModel> {
        return client.get("/shopping/items") { }.body()
    }

    override suspend fun deleteItem(id: Long) {
        client.delete("/shopping/item/$id") { }
    }

    override suspend fun updateItem(item: ShoppingItemModel) {
        client.put("/shopping/item/${item.id}") { setBody(item) }
    }
}