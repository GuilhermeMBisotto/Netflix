package com.guilhermebisotto.netflix.data

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

suspend fun <T> request(getRequest: Deferred<Response<T?>>) =
    withContext(Dispatchers.IO) {
        getRequest.await()
    }

const val ERROR_CODE = 5000
const val GENERIC_ERROR_MSG =
    "{\"message\":[\"Ops... Ocorreu um erro, tente novamente mais tarde.\"]}"