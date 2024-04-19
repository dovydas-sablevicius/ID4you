package com.project.id4you.presentation.screens.documentQrScan

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTDecodeException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class DocumentQrScanViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(DocumentQrScanState())
    val state: State<DocumentQrScanState> = _state

    fun onBarcodeDetect(text: String) {
        Log.i("myTag", text)
        val (documentId, expiresAt) = decodeAndVerifyJwt(text)
        Log.i("myTag", "$documentId $expiresAt")

        if (documentId == null || expiresAt == null) {
            _state.value = DocumentQrScanState(
                error = Constants.DOCUMENT_NOT_FOUND_ERROR_MSG,
                isLoading = false
            )
            resetErrorAfterDelay()
        } else {
            if (isQrCodeNotExpired(expiresAt)) {
                _state.value =
                    DocumentQrScanState(
                        isSuccess = true,
                        documentId = documentId ?: "",
                        isLoading = false
                    )
            } else {
                _state.value = DocumentQrScanState(
                    error = Constants.DOCUMENT_EXPIRED_ERROR_MSG,
                    isLoading = false
                )
                resetErrorAfterDelay()
            }
        }
    }

    private fun resetErrorAfterDelay() {
        viewModelScope.launch {
            delay(Constants.RESET_ERROR_DELAY_MS)
            _state.value = _state.value.copy(error = "")
        }
    }

    private fun isQrCodeNotExpired(expiresAt: Long?): Boolean {
        expiresAt ?: return false

        val currentTime = Date(System.currentTimeMillis())
        val expirationDate = Date(expiresAt / 1000)

        return currentTime.before(expirationDate)
    }

    private fun decodeAndVerifyJwt(jwtToken: String): Pair<String?, Long?> {
        val secret = "secret"

        try {
            val decodedToken = JWT.require(Algorithm.HMAC256(secret))
                .ignoreIssuedAt()
                .build()
                .verify(jwtToken)

            val documentId = decodedToken.getClaim("documentId").asString()
            val expiresAt = decodedToken.expiresAt?.time
            return Pair(documentId, expiresAt)
        } catch (e: JWTDecodeException) {
            return Pair(null, null)
        } catch (e: Exception) {
            return Pair(null, null)
        }

    }

    fun onEvent(event: DocumentQrScanEvent) {
        when (event) {
            is DocumentQrScanEvent.onBarcodeDetectEvent -> {
                onBarcodeDetect(event.scannedText)
            }
        }
    }
}