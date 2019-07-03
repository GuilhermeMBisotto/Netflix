package com.guilhermebisotto.netflix.utils.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.guilhermebisotto.netflix.utils.bindingadapter.helpers.BindableAdapter

@BindingAdapter("app:data")
fun <T> RecyclerView.setRecyclerViewProperties(data: T?) {
    if (this.adapter is BindableAdapter<*>) {
        (this.adapter as BindableAdapter<T>).setData(data)
    }
}