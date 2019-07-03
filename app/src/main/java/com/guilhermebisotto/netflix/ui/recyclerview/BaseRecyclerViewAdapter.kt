package com.guilhermebisotto.netflix.ui.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.guilhermebisotto.netflix.BR

abstract class BaseRecyclerViewAdapter :
    RecyclerView.Adapter<BaseRecyclerViewAdapter.BaseViewHolder>() {

    protected abstract fun getObjForPosition(position: Int): Any
    protected abstract fun getLayoutIdForPosition(position: Int): Int
    protected abstract fun getAdapter(position: Int): BaseRecyclerViewAdapter

    class BaseViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val layoutManager: LinearLayoutManager = LinearLayoutManager(binding.root.context)

        fun bind(obj: Any) {
            binding.setVariable(BR.obj, obj)
            binding.executePendingBindings()
        }

        fun bind(
            adapter: BaseRecyclerViewAdapter
        ) {
            binding.setVariable(BR.adapter, adapter)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        BaseViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), viewType, parent, false
            )
        )

    override fun getItemCount(): Int = 0

    override fun onBindViewHolder(
        holder: BaseViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            val args = (payloads[0]) as Bundle
            for (key in args.keySet()) {
                if (key == "items") {
                    holder.bind(getAdapter(position))
                    holder.bind(getObjForPosition(position))
                }
            }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(getAdapter(position))
        holder.bind(getObjForPosition(position))
    }

    override fun getItemViewType(position: Int): Int = getLayoutIdForPosition(position)
}