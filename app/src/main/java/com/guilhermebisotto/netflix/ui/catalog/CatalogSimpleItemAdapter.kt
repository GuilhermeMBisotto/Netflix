package com.guilhermebisotto.netflix.ui.catalog

import android.view.View
import com.guilhermebisotto.netflix.R
import com.guilhermebisotto.netflix.data.catalog.models.CatalogItemModel
import com.guilhermebisotto.netflix.ui.recyclerview.BaseRecyclerViewAdapter
import com.guilhermebisotto.netflix.utils.bindingadapter.helpers.BindableAdapter

class CatalogSimpleItemAdapter(
    private val itemClicked: (CatalogItemModel) -> Unit,
    private val itemLongClicked: (CatalogItemModel) -> Unit
) : BaseRecyclerViewAdapter(), BindableAdapter<List<CatalogItemModel>> {

    private var items: List<CatalogItemModel> = listOf()

    override fun getObjForPosition(position: Int): Any = items[position]
    override fun getLayoutIdForPosition(position: Int): Int = R.layout.item_catalog
    override fun getItemCount(): Int = items.size
    override fun getAdapter(position: Int): BaseRecyclerViewAdapter = this

    /*
    * STORE POSITION
    *
    * private val positionList = SparseIntArray()
    *
    * override fun onViewRecycled(holder: BaseViewHolder) {
    *       val firstVisiblePosition = holder.layoutManager.findFirstVisibleItemPosition()
    *       positionsArray.put(positionBase, firstVisiblePosition)
    *       super.onViewRecycled(holder)
    * }
    *
    * --------------------------------------------
    *
    * RETRIEVE AND SET THE SAVED POSITION
    *
    * override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
    *       super.onBindViewHolder(holder, position)
    *       val lastSeenFirstPosition = positionsArray.get(position, 0)
    *       if (lastSeenFirstPosition != 0) {
    *           holder.layoutManager.scrollToPositionWithOffset(lastSeenFirstPosition, 0)
    *       } else {
    *           holder.layoutManager.scrollToPositionWithOffset(0, 0)
    *       }
    * }
    *
    * */

    override fun setData(data: List<CatalogItemModel>?) {
        if (data != null) {
            this.items = data
        } else {
            this.items = listOf()
        }
        notifyDataSetChanged()
    }

    fun onItemClicked(view: View, item: CatalogItemModel) = itemClicked(item)
    fun onItemLongClicked(view: View, item: CatalogItemModel): Boolean {
        itemLongClicked(item)
        return true
    }
}