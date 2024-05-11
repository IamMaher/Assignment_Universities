package com.example.ui.extension

import androidx.fragment.app.Fragment
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

fun <T : Any, L : Flow<T>> Fragment.observe(flow: L, body: (T) -> Unit) =
    viewLifecycleOwner.lifecycleScope.launch { flow.flowWithLifecycle(this@observe.lifecycle).collect(body) }