package com.jetbrains.kmpapp.di

import com.jetbrains.kmpapp.presentation.screens.additem.AddItemScreenModel
import com.jetbrains.kmpapp.presentation.screens.edititem.EditItemScreenModel
import com.jetbrains.kmpapp.presentation.screens.list.ListScreenModel
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val networkingModule = module {
    //TODO
}

val dataModule = module {
    //TODO
}

val screenModelsModule = module {
    factoryOf(::AddItemScreenModel)
    factoryOf(::ListScreenModel)
    factoryOf(::EditItemScreenModel)
}

fun initKoin() {
    startKoin {
        modules(
            networkingModule,
            screenModelsModule,
            dataModule,
        )
    }
}
