package com.project.id4you.presentation.screens.documentQrScan

import android.annotation.SuppressLint
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage

class QrCodeAnalyzer(private val onEvent: (DocumentQrScanEvent) -> Unit) : ImageAnalysis.Analyzer {

    private val options = BarcodeScannerOptions.Builder()
        .setBarcodeFormats(Barcode.FORMAT_ALL_FORMATS)
        .build()

    private var lastAnalyzedTime = 0L // 1 second delay

    private val scanner = BarcodeScanning.getClient(options)

    @SuppressLint("UnsafeOptInUsageError")
    override fun analyze(imageProxy: ImageProxy) {
        val currentTimeMillis = System.currentTimeMillis()

        if (currentTimeMillis - lastAnalyzedTime >= Constants.DELAY_BETWEEN_FRAMES_MS) {
            lastAnalyzedTime = currentTimeMillis

            imageProxy.image?.let { image ->
                scanner.process(
                    InputImage.fromMediaImage(
                        image, imageProxy.imageInfo.rotationDegrees
                    )
                ).addOnSuccessListener { barcode ->
                    barcode?.takeIf { it.isNotEmpty() }
                        ?.mapNotNull { it.rawValue }
                        ?.joinToString(",")
                        ?.let {
                            onEvent(DocumentQrScanEvent.OnBarcodeDetectEvent(it))
                        }
                }.addOnCompleteListener {
                    imageProxy.close()
                }
            }
        } else {
            imageProxy.close()
        }
    }
}