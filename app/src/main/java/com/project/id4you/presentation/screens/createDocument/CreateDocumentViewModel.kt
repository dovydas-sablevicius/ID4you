package com.project.id4you.presentation.screens.createDocument

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@Suppress("TooGenericExceptionThrown")
@HiltViewModel
class CreateDocumentViewModel @Inject constructor(
    //savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf((CreateDocumentState()))
    val state: State<CreateDocumentState> = _state

    fun onEvent(event: CreateDocumentEvent) {
        when (event) {
            is CreateDocumentEvent.EnteredName -> {
                _state.value = state.value.copy(name = event.value)
            }

            is CreateDocumentEvent.EnteredDocumentType -> {
                _state.value = state.value.copy(documentType = event.value)
            }

            CreateDocumentEvent.PressedContinueButton -> {
                _state.value = state.value.copy(error = "You must fill all empty fields.")
            }
        }
    }
}

