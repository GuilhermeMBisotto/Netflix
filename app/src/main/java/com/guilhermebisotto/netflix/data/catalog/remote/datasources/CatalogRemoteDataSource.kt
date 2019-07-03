package com.guilhermebisotto.netflix.data.catalog.remote.datasources

import com.guilhermebisotto.netflix.data.RetrofitInitializer
import com.guilhermebisotto.netflix.data.catalog.models.CatalogModel
import com.guilhermebisotto.netflix.data.catalog.remote.services.CatalogApiService
import com.guilhermebisotto.netflix.data.request
import retrofit2.Response

class CatalogRemoteDataSource :
    CatalogDataSource.Remote {

    private val catalogApiService: CatalogApiService = RetrofitInitializer().catalogApiService()

    override suspend fun getCatalog(): Response<List<CatalogModel?>?> =
        request(catalogApiService.getCatalogAsync())
}