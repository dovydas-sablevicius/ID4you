package com.project.id4you.presentation.screens.documentDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.id4you.common.ExceptionMessages
import com.project.id4you.common.Resource
import com.project.id4you.domain.useCase.getDocument.GetDocumentUseCase
import com.project.id4you.presentation.singleton.AuthToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@Suppress("TooGenericExceptionThrown")
@HiltViewModel
class DocumentDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getDocumentUseCase: GetDocumentUseCase

) : ViewModel() {
    private val _state = mutableStateOf((DocumentDetailState()))
    val state: State<DocumentDetailState> = _state

    init {
        getDocument(AuthToken.value, getDocumentId())
    }

    private fun getDocumentId(): String {
        return savedStateHandle.get<String>("documentId")
            ?: throw Exception("Failed To Get Document Id")
    }

    private fun getSourceScreen(): Boolean {
        val stringValue = savedStateHandle.get<String>("isScanned")
        return stringValue?.toBoolean() ?: false
    }

    private fun getDocument(authToken: String, id: String) {
        viewModelScope.launch {
            getDocumentUseCase(authToken, id).onEach { result ->
                when (result) {
                    is Resource.Error -> {
                        _state.value = DocumentDetailState(
                            error = result.message ?: ExceptionMessages.unexpectedErrorMessage
                        )
                    }

                    is Resource.Loading -> {
                        _state.value = DocumentDetailState(
                            isLoading = true,
                        )
                    }

                    is Resource.Success -> {
                        _state.value = DocumentDetailState(
                            document = result.data,
                            isSuccess = true,
                            isScanned = getSourceScreen()
                        )
                    }
                }

            }.launchIn(viewModelScope)
        }
    }

}
