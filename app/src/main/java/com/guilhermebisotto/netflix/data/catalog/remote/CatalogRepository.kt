package com.guilhermebisotto.netflix.data.catalog.remote

import com.guilhermebisotto.netflix.data.catalog.models.CatalogModel
import com.guilhermebisotto.netflix.data.catalog.remote.datasources.CatalogRemoteDataSource

class CatalogRepository {

    private val remoteDataSource =
        CatalogRemoteDataSource()

    suspend fun getCatalog(): List<CatalogModel?> =
        remoteDataSource.getCatalog().body() ?: listOf()
}