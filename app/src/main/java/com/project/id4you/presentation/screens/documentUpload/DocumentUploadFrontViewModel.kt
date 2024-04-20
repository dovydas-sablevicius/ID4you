package com.project.id4you.presentation.screens.documentUpload

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@Suppress("TooGenericExceptionThrown")
@HiltViewModel
class DocumentUploadFrontViewModel @Inject constructor(
) : ViewModel() {
    private val _state = mutableStateOf((DocumentUploadFrontState()))
    val state: State<DocumentUploadFrontState> = _state
}