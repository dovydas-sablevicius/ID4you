package com.project.id4you.presentation.screens.documentQr

import android.graphics.Bitmap
import com.project.id4you.presentation.screens.documentQr.Constants.JWT_EXPIRATION_TIME
import com.project.id4you.presentation.screens.documentQr.Constants.THOUSAND_MILLISECONDS
import org.junit.Test

class DocumentQrStateTest {
    @Test
    fun testDefaultDocumentQrState() {
        val defaultState = generateDefaultDocumentQrState()
        assert(!defaultState.isLoading)
        assert(defaultState.error == "")
        assert(!defaultState.isSuccess)
        assert(defaultState.documentId == "")
        assert(defaultState.documentQrCode == null)
        assert(defaultState.qrCodeRemainingTime == JWT_EXPIRATION_TIME / THOUSAND_MILLISECONDS)
    }

    @Test
    fun testLoadingDocumentQrState() {
        val loadingState = generateDocumentQrStateLoading()
        assert(loadingState.isLoading)
        assert(!loadingState.isSuccess)
        assert(loadingState.error == "")
        assert(loadingState.documentId == "")
        assert(loadingState.documentQrCode == null)
    }

    @Test
    fun testSuccessDocumentQrState() {
        val documentId: String = "12345"
        val documentQrCode: Bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)

        val successState = generateDocumentQrStateSuccess(documentId, documentQrCode)

        assert(successState.isSuccess)
        assert(!successState.isLoading)
        assert(successState.error == "")
        assert(successState.documentId == documentId)
        assert(successState.documentQrCode == documentQrCode)
    }

    @Test
    fun testErrorDocumentQrState() {
        val error: String = "Unexpected Error"
        val errorState = generateDocumentQrStateError(error)
        assert(!errorState.isSuccess)
        assert(!errorState.isLoading)
        assert(errorState.error == error)
        assert(errorState.documentId == "")
        assert(errorState.documentQrCode == null)
    }
}

fun generateDefaultDocumentQrState(): DocumentQrState {
    return DocumentQrState()
}

fun generateDocumentQrStateError(error: String): DocumentQrState {
    return DocumentQrState(error = error)
}

fun generateDocumentQrStateLoading(): DocumentQrState {
    return DocumentQrState(isLoading = true)
}

fun generateDocumentQrStateSuccess(documentId: String, documentQrCode: Bitmap): DocumentQrState {
    return DocumentQrState(
        documentId = documentId,
        documentQrCode = documentQrCode,
        isSuccess = true
    )
}
