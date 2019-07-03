package com.guilhermebisotto.netflix.data.catalog.remote.services

import com.guilhermebisotto.netflix.data.catalog.models.CatalogModel
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface CatalogApiService {

    @GET("todos")
    fun getCatalogAsync(): Deferred<Response<List<CatalogModel?>?>>
}