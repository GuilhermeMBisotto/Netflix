package com.guilhermebisotto.netflix.ui.catalog

import android.os.Bundle
import android.view.WindowManager
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.guilhermebisotto.netflix.R
import com.guilhermebisotto.netflix.databinding.ActivityCatalogBinding

class CatalogActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCatalogBinding
    private val viewModel: CatalogViewModel = CatalogViewModel()
    private val adapter: CatalogSectionsAdapter by lazy {
        CatalogSectionsAdapter({
            Toast.makeText(this, "Item Clicked: $it", Toast.LENGTH_SHORT).show()
        }) {
            Toast.makeText(this, "Item Long Clicked: $it", Toast.LENGTH_SHORT).show()
        }
    }

    private var actualYScroll = 0
    private var finalTop: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_catalog
        )
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerViewCatalog.adapter = adapter
        finalTop = binding.customToolbar.top

        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)



        binding.recyclerViewCatalog.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

                if (dy > actualYScroll) {

                    // binding.customToolbar

                    binding.customToolbar.animate().translationY(-10f).setInterpolator(
                        AccelerateDecelerateInterpolator()
                    ).duration = 10
                } else {
                    binding.customToolbar.animate().translationY(10f).setInterpolator(
                        AccelerateDecelerateInterpolator()
                    ).duration = 10
                }

                actualYScroll = dy
                super.onScrolled(recyclerView, dx, dy)
            }
        })
        // val params = binding.coordinatorCatalog.layoutParams as CoordinatorLayout.LayoutParams
        // params.behavior = AppBarLayout.ScrollingViewBehavior()

        // configureRecycler()
    }

    // private fun configureRecycler() {
    //     binding.recyclerViewCatalog.addOnScrollListener(object : RecyclerView.OnScrollListener() {
    //         override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
    //             super.onScrolled(recyclerView, dx, dy)
    //             val layout = binding.collapsingToolbarLayoutCatalog.layoutParams
    //
    //             binding.appbarCatalog.animate()
    //                 .translationY(dy.toFloat()).setInterpolator(
    //                     LinearInterpolator()).duration = 10
    //
    //             // when {
    //             //     dy >= layout.height -> binding.appbarCatalog.animate()
    //             //         .translationY((-binding.appbarCatalog.height).toFloat()).setInterpolator(
    //             //         LinearInterpolator()
    //             //     ).duration = 500
    //             //     dy <= layout.height -> binding.appbarCatalog.animate().translationY(0F).setInterpolator(
    //             //         LinearInterpolator()
    //             //     ).setDuration(500).setListener(object :
    //             //         AnimatorListenerAdapter() {
    //             //         override fun onAnimationEnd(animation: Animator?) {
    //             //             binding.appbarCatalog.elevation = 16f
    //             //         }
    //             //     })
    //             //     else -> {
    //             //         layout.height = -dy
    //             //         binding.collapsingToolbarLayoutCatalog.layoutParams = layout
    //             //         binding.collapsingToolbarLayoutCatalog.requestLayout()
    //             //     }
    //             // }
    //         }
    //     })
    // }
}
