package com.project.id4you.presentation.screens.documentDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DocumentDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle

) : ViewModel() {
    private val _state = mutableStateOf((DocumentDetailState()))
    val state: State<DocumentDetailState> = _state

    init {
        savedStateHandle.get<String>("documentId")?.let { documentId ->
            _state.value = state.value.copy(documentId = documentId)
        }
    }
}
