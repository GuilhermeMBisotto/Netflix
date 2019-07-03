package com.guilhermebisotto.netflix.utils

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import com.guilhermebisotto.netflix.data.catalog.models.CatalogModel

class CatalogDiffCallback(
    private val oldList: List<CatalogModel?>?,
    private val newList: List<CatalogModel?>?
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        if (oldList.isNullOrEmpty() && newList.isNullOrEmpty()) {
            false
        } else {
            if (!oldList.isNullOrEmpty() && !newList.isNullOrEmpty()) {
                val old = oldList[oldItemPosition]
                val new = newList[newItemPosition]

                old === new
            } else {
                false
            }
        }

    override fun getOldListSize(): Int = if (oldList.isNullOrEmpty()) 0 else oldList.size

    override fun getNewListSize(): Int = if (newList.isNullOrEmpty()) 0 else newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        if (oldList.isNullOrEmpty() && newList.isNullOrEmpty()) {
            false
        } else {
            if (!oldList.isNullOrEmpty() && !newList.isNullOrEmpty()) {
                val old = oldList[oldItemPosition]
                val new = newList[newItemPosition]

                old === new
            } else {
                false
            }
        }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        if (oldList.isNullOrEmpty() && newList.isNullOrEmpty()) {
            return null
        } else {

            var oldItem: CatalogModel? = null
            oldList?.run {
                oldItem = this[oldItemPosition]
            }

            var newItem: CatalogModel? = null
            newList?.run {
                newItem = this[newItemPosition]
            }

            val diff = Bundle()
            if (newItem !== oldItem) {
                diff.putParcelable("item", newItem)
            }

            return if (diff.size() == 0) {
                null
            } else {
                diff
            }
        }
    }
}