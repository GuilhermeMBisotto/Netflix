package com.guilhermebisotto.netflix.ui.catalog

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.guilhermebisotto.netflix.data.catalog.models.CatalogModel
import com.guilhermebisotto.netflix.data.catalog.remote.CatalogRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlin.coroutines.CoroutineContext

class CatalogViewModel : ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    private val catalogRepository =
        CatalogRepository()

    private val _catalog: LiveData<List<CatalogModel?>> = liveData(coroutineContext) {
        val list: MutableList<CatalogModel?> = catalogRepository.getCatalog().toMutableList()

        emit(list.toList().subList(0, 2))
        delay(2_000)
        emit(list.toList().subList(0, 4).reversed())
        delay(2_000)
        emit(list.toList().subList(0, 20))
    }
    val catalog: LiveData<List<CatalogModel?>> = Transformations.map(_catalog) {
        // if (!it.isNullOrEmpty()) {
        //     if (it.size > 20) {
        //         it.subList(0, 20)
        //     } else {
        //         it
        //     }
        // } else {
        //     it
        // }

        it
    }
}