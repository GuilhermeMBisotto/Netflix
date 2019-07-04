package com.guilhermebisotto.netflix.ui.catalog

import androidx.recyclerview.widget.DiffUtil
import com.guilhermebisotto.netflix.R
import com.guilhermebisotto.netflix.data.catalog.models.CatalogItemModel
import com.guilhermebisotto.netflix.data.catalog.models.CatalogModel
import com.guilhermebisotto.netflix.ui.recyclerview.BaseRecyclerViewAdapter
import com.guilhermebisotto.netflix.utils.CatalogDiffCallback
import com.guilhermebisotto.netflix.utils.bindingadapter.helpers.BindableAdapter

class CatalogSectionsAdapter(
    private val itemClicked: (CatalogItemModel) -> Unit,
    private val itemLongClicked: (CatalogItemModel) -> Unit
) : BaseRecyclerViewAdapter(),
    BindableAdapter<List<CatalogModel>> {

    private var items: List<CatalogModel> = listOf()

    override fun getAdapter(position: Int): BaseRecyclerViewAdapter =
        CatalogSimpleItemAdapter({
            onItemClicked(it)
        }) {
            onItemLongClicked(it)
        }

    override fun getLayoutIdForPosition(position: Int): Int =
        if (position == 0) R.layout.item_catalog_header else R.layout.item_catalog_sections

    override fun getItemCount(): Int = items.size
    override fun getObjForPosition(position: Int): Any = items[position]

    override fun setData(data: List<CatalogModel>?) {
        val diffResult = DiffUtil.calculateDiff(CatalogDiffCallback(items, data))
        diffResult.dispatchUpdatesTo(this)
        data?.run {
            this@CatalogSectionsAdapter.items = this
        }

        // if (data != null) {
        //     this.items = data
        // } else {
        //     this.items = listOf()
        // }
        // notifyDataSetChanged()
    }

    private fun onItemClicked(item: CatalogItemModel) = itemClicked(item)
    private fun onItemLongClicked(item: CatalogItemModel) = itemLongClicked(item)
}