package com.project.id4you.presentation.documentsList

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.id4you.common.ExceptionMessages
import com.project.id4you.common.Resource
import com.project.id4you.domain.useCase.getIdCards.GetIdCardsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DocumentsListViewModel @Inject constructor(
    private val getIdCardsUseCase: GetIdCardsUseCase
) : ViewModel() {
    private val _state = mutableStateOf(DocumentsListState())
    val state: State<DocumentsListState> = _state

    init {
        getDocuments(
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjb2xsZWN0aW9uSWQiOiJfcGJfdXNlcnNfYXV0aF8iLCJleHAiOjE3MTIwMDc0MTIsImlkIjoiNDQ5MG1rNzlva" +
                    "zRiOXlqIiwidHlwZSI6ImF1dGhSZWNvcmQifQ.-5lq5yHy7vnnZuWECckhheVMdS8QbOOTldaeTMLgpZA"
        )
    }

    fun getDocuments(authToken: String) {
        viewModelScope.launch {
            getIdCardsUseCase(authToken).onEach { result ->
                when (result) {
                    is Resource.Error -> {
                        _state.value =
                            DocumentsListState(
                                error = result.message ?: ExceptionMessages.unexpectedErrorMessage
                            )
                    }

                    is Resource.Loading -> {
                        _state.value = DocumentsListState(isLoading = true)
                    }

                    is Resource.Success -> {
                        _state.value =
                            DocumentsListState(
                                isLoading = false,
                                documents = result.data ?: emptyList()
                            )
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}
