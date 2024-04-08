package com.project.id4you.presentation.screens.documentQr

import android.graphics.Bitmap
import com.project.id4you.presentation.screens.documentQr.Constants.JWT_EXPIRATION_TIME
import com.project.id4you.presentation.screens.documentQr.Constants.THOUSAND_MILLISECONDS

data class DocumentQrState(
    val isLoading: Boolean = false,
    val error: String = "",
    val isSuccess: Boolean = false,
    val documentId: String = "",
    val documentQrCode: Bitmap? = null,
    val qrCodeRemainingTime: Int = JWT_EXPIRATION_TIME / THOUSAND_MILLISECONDS
)
