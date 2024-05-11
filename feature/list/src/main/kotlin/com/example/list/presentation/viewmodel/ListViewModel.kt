package com.example.list.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.list.domain.usecase.GetUniversitiesUseCase
import com.example.list.presentation.view.ListUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class ListViewModel @Inject constructor(private val getUniversitiesUseCase: GetUniversitiesUseCase) : ViewModel() {
    private val _uiState: MutableStateFlow<ListUIState> = MutableStateFlow(ListUIState.Empty)
    val uiState: StateFlow<ListUIState> = _uiState.asStateFlow()

    init {
        getUniversities()
    }

    fun getUniversities() {
        viewModelScope.launch {
            ListUIState.Loading.also { _uiState.value = it }
            getUniversitiesUseCase.execute().apply {
                onSuccess { list -> ListUIState.Success(list).also { _uiState.value = it } }
                onFailure { throwable -> ListUIState.Fail(throwable).also { _uiState.value = it } }
            }
        }
    }
}