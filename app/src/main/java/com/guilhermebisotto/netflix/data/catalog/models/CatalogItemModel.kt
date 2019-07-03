package com.guilhermebisotto.netflix.data.catalog.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CatalogItemModel(
    val image: String? = "https://i.stack.imgur.com/chfhv.png"
) : Parcelable