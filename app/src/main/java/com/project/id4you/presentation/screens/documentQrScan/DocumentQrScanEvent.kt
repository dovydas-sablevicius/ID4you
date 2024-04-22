package com.project.id4you.presentation.screens.documentQrScan

sealed class DocumentQrScanEvent {
    data class OnBarcodeDetectEvent(val scannedText: String) : DocumentQrScanEvent()
}
