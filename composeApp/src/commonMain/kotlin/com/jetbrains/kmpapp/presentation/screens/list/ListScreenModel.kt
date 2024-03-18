package com.jetbrains.kmpapp.presentation.screens.list

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.StateScreenModel
import com.jetbrains.kmpapp.data.MuseumObject
import com.jetbrains.kmpapp.data.MuseumRepository
import com.jetbrains.kmpapp.domain.entities.ShoppingItem
import com.jetbrains.kmpapp.navigator
import com.jetbrains.kmpapp.presentation.screens.edititem.EditItemScreen
import kotlinx.coroutines.flow.Flow

class ListScreenModel(
    private val museumRepository: MuseumRepository,
) : StateScreenModel<ListState>(ListState()) {

    fun onDeleteClick(shoppingItem: ShoppingItem) {
        //TODO("Not yet implemented")
    }

    fun onItemClick(shoppingItem: ShoppingItem) {
        navigator.push(EditItemScreen(shoppingItem))
    }

    fun onBackButtonClick() {
        navigator.pop()
    }

//    fun getObject(objectId: Int): Flow<MuseumObject?> =
//        museumRepository.getObjectById(objectId)
}
