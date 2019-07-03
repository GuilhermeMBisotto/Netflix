package com.guilhermebisotto.netflix.utils.bindingadapter.helpers

import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.guilhermebisotto.netflix.R

fun loadAppCompatImageView(image: AppCompatImageView, imageUrl: String?) {
    Glide.with(image.context)
        .load(imageUrl)
        .apply(
            RequestOptions()
                .dontTransform()
                .error(R.drawable.ic_launcher_background)
        )
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(image)
}

fun loadImageView(image: ImageView, imageUrl: String?) {
    Glide.with(image.context)
        .load(imageUrl)
        .apply(
            RequestOptions()
                .dontTransform()
                .error(R.drawable.ic_launcher_background)
        )
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(image)
}

fun loadRoundedAppCompatImageView(image: AppCompatImageView, imageUrl: String?, round: Int) {
    Glide.with(image.context)
        .load(imageUrl)
        .apply(
            RequestOptions()
                .dontTransform()
                .error(R.drawable.ic_launcher_background)
        )
        .placeholder(R.mipmap.ic_launcher)
        .transform(CenterCrop(), RoundedCorners(round))
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(image)
}

fun loadRoundedImageView(image: ImageView, imageUrl: String?, round: Int) {
    Glide.with(image.context)
        .load(imageUrl)
        .apply(
            RequestOptions()
                .dontTransform()
                .error(R.drawable.ic_launcher_background)
        )
        .placeholder(R.mipmap.ic_launcher)
        .transform(CenterCrop(), RoundedCorners(round))
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(image)
}