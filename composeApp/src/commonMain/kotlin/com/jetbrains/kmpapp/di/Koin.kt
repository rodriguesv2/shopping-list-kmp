package com.jetbrains.kmpapp.di

import com.jetbrains.kmpapp.data.datasources.ShoppingDatasource
import com.jetbrains.kmpapp.data.datasources.ShoppingDatasourceImpl
import com.jetbrains.kmpapp.data.repositories.ShoppingRepositoryRemote
import com.jetbrains.kmpapp.domain.repositories.ShoppingRepository
import com.jetbrains.kmpapp.presentation.screens.additem.AddItemScreenModel
import com.jetbrains.kmpapp.presentation.screens.edititem.EditItemScreenModel
import com.jetbrains.kmpapp.presentation.screens.list.ListScreenModel
import com.jetbrains.kmpapp.utils.Platform
import com.jetbrains.kmpapp.utils.getPlatform
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkingModule = module {
    single {
        HttpClient {
            expectSuccess = true
            install(ContentNegotiation) {
                json(
                    json = Json { ignoreUnknownKeys = true },
                    contentType = ContentType.Application.Json,
                )
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
            defaultRequest {
                contentType(ContentType.Application.Json)
                url(
                    when (getPlatform()) {
                        Platform.ANDROID -> "http://10.0.2.2:8080/"
                        Platform.IOS -> "http://localhost:8080/"
                    }
                )
            }
        }
    }
}

val dataModule = module {
    singleOf(::ShoppingDatasourceImpl) bind ShoppingDatasource::class
    singleOf(::ShoppingRepositoryRemote) bind ShoppingRepository::class
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
