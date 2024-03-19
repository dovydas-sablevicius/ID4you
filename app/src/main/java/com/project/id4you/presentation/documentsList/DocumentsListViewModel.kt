package com.project.id4you.presentation.documentsList

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.id4you.common.ExceptionMessages
import com.project.id4you.common.Resource
import com.project.id4you.domain.useCase.getIdCards.GetIdCardsUseCase
import com.project.id4you.presentation.singleton.AuthToken
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
        getDocuments(AuthToken.value)
    }

    private fun getDocuments(authToken: String) {
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
                        _state.value = DocumentsListState(isLoading = false)
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
