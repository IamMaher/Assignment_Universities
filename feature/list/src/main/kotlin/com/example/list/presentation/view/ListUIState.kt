package com.example.list.presentation.view

import com.example.domain.model.University
import com.example.ui.UIState

sealed interface ListUIState : UIState {
    data object Empty : ListUIState
    data object Loading : ListUIState

    class Success(val list: List<University>) : ListUIState

    class Fail(val throwable: Throwable) : ListUIState
}