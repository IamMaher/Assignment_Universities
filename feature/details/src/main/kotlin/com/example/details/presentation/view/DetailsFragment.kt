package com.example.details.presentation.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.details.R
import com.example.details.databinding.FragmentDetailsBinding
import com.example.domain.model.University
import com.example.ui.extension.parcelable
import com.example.ui.extension.viewBinding

class DetailsFragment : Fragment(R.layout.fragment_details) {
    private val binding by viewBinding(FragmentDetailsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        arguments?.parcelable<University>("item")?.let { initView(it) }
    }


    private fun setListeners() {
        binding.btnRefresh.setOnClickListener {

        }
    }

    private fun initView(university: University) {
        with(binding) {
            tvName.text = university.name
            tvState.text = university.stateProvince
            tvCountry.text = university.country
            tvWebpage.text = university.webPage
            tvCountryCode.text = university.alphaTwoCode
        }
    }
}