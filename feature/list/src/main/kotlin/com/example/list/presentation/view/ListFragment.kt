package com.example.list.presentation.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import com.example.di.DaggerCoreComponent
import com.example.list.R
import com.example.list.databinding.FragmentListBinding
import com.example.list.di.DaggerListComponent
import com.example.list.presentation.adapter.UniversitiesAdapter
import com.example.list.presentation.viewmodel.ListViewModel
import com.example.navigation.extension.NavigationKeys.DETAILS_SCREEN_KEY
import com.example.navigation.extension.NavigationKeys.REFRESH_KEY
import com.example.navigation.extension.navigateSafe
import com.example.ui.App
import com.example.ui.extension.observe
import com.example.ui.extension.viewBinding
import javax.inject.Inject

class ListFragment : Fragment(R.layout.fragment_list) {
    private val binding by viewBinding(FragmentListBinding::bind)
    @Inject
    lateinit var factory : ViewModelProvider.Factory

    private val viewModel: ListViewModel by lazy { ViewModelProvider(this, factory)[ListViewModel::class.java] }
    private val adapter by lazy { UniversitiesAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        with(viewModel) { observe(uiState, ::renderState) }
    }

    override fun onAttach(context: Context) {
        initDaggerComponent()
        super.onAttach(context)
    }

    private fun initDaggerComponent() {
        DaggerListComponent
            .builder()
            .coreComponent(App.coreComponent(requireContext()))
            .build()
            .inject(this)
    }

    private fun initUI() {
        binding.rvUniversities.adapter = adapter
        adapter.select = { item ->
           findNavController().navigate(R.id.detailsFragment, bundleOf("item" to item))
        }
    }

    private fun renderState(uiState: ListUIState) {
        when (uiState) {
            is ListUIState.Loading -> showLoading()
            is ListUIState.Empty -> resetAdapter()
            is ListUIState.Success -> {
                hideLoading()
                adapter.submitList(uiState.list)
            }

            is ListUIState.Fail -> {
                hideLoading()
                resetAdapter()
                Toast.makeText(context, uiState.throwable.localizedMessage, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun resetAdapter() {
        adapter.submitList(null)
    }

    private fun showLoading() {
        binding.progress.isVisible = true
    }

    private fun hideLoading() {
        binding.progress.isVisible = false
    }
}