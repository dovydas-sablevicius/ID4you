package com.project.id4you.presentation.screens.documentQr

sealed class DocumentQrEvent {
    data object RegenerateQrCode : DocumentQrEvent()
}
