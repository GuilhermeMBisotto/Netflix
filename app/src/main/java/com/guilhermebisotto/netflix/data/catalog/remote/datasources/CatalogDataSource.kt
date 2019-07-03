package com.guilhermebisotto.netflix.data.catalog.remote.datasources

import com.guilhermebisotto.netflix.data.catalog.models.CatalogModel
import retrofit2.Response

interface CatalogDataSource {

    interface Remote {
        suspend fun getCatalog(): Response<List<CatalogModel?>?>
    }
}