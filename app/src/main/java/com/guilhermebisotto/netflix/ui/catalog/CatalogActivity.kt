package com.guilhermebisotto.netflix.ui.catalog

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_catalog)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerViewCatalog.adapter = adapter
    }
}
