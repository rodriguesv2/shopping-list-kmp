package com.jetbrains.kmpapp.utils.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun <T> CoroutineScope.launchRequest(
    block: suspend () -> T,
    onLoading: (Boolean) -> Unit,
    onSuccess: (T) -> Unit,
    onError: (Throwable) -> Unit,
) {
    launch {
        try {
            onLoading(true)
            val response = block()
            onSuccess(response)
        } catch (e: Exception) {
            println(e)
            onError(e)
        } finally {
            onLoading(false)
        }
    }
}