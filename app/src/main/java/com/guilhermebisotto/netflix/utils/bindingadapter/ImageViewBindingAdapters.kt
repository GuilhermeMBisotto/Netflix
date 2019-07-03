package com.guilhermebisotto.netflix.utils.bindingadapter

import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.guilhermebisotto.netflix.utils.bindingadapter.helpers.loadAppCompatImageView
import com.guilhermebisotto.netflix.utils.bindingadapter.helpers.loadImageView
import com.guilhermebisotto.netflix.utils.bindingadapter.helpers.loadRoundedAppCompatImageView
import com.guilhermebisotto.netflix.utils.bindingadapter.helpers.loadRoundedImageView

@BindingAdapter("app:imageSet", "app:rounded", requireAll = false)
fun AppCompatImageView.imageFromUrl(imageUrl: String?, rounded: Boolean = false) {
    if (rounded) {
        loadRoundedAppCompatImageView(
            this,
            imageUrl,
            32
        )
    } else {
        loadAppCompatImageView(this, imageUrl)
    }
}

@BindingAdapter("app:imageSet", "app:rounded", requireAll = false)
fun ImageView.imageFromUrl(imageUrl: String?, rounded: Boolean = false) {
    if (rounded) {
        loadRoundedImageView(this, imageUrl, 32)
    } else {
        loadImageView(this, imageUrl)
    }
}