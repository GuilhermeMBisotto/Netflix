package com.guilhermebisotto.netflix.data.catalog.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CatalogModel(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean,
    val items: List<CatalogItemModel>?
) : Parcelable {
    fun getItemsList() = mutableListOf(
        CatalogItemModel(),
        CatalogItemModel(),
        CatalogItemModel(),
        CatalogItemModel(),
        CatalogItemModel(),
        CatalogItemModel(),
        CatalogItemModel(),
        CatalogItemModel(),
        CatalogItemModel(),
        CatalogItemModel(),
        CatalogItemModel(),
        CatalogItemModel()
    )

    fun getImageBanner() = "https://i.stack.imgur.com/chfhv.png"
}