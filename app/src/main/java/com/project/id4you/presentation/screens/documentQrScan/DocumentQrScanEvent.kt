package com.project.id4you.presentation.screens.documentQrScan

sealed class DocumentQrScanEvent {
    data class onBarcodeDetectEvent(val scannedText: String) : DocumentQrScanEvent()
}
