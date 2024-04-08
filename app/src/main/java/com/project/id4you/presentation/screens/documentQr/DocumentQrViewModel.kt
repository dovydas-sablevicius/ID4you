package com.project.id4you.presentation.screens.documentQr

import android.graphics.Bitmap
import android.graphics.Color
import android.os.CountDownTimer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel
import com.project.id4you.presentation.screens.documentQr.Constants.JWT_EXPIRATION_TIME
import com.project.id4you.presentation.screens.documentQr.Constants.QR_CODE_HEIGHT
import com.project.id4you.presentation.screens.documentQr.Constants.QR_CODE_WIDTH
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class DocumentQrViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(DocumentQrState())
    val state: State<DocumentQrState> = _state
    private var countDownTimer: CountDownTimer? = null

    init {
        savedStateHandle.get<String>("documentId")?.let { documentId ->
            _state.value = state.value.copy(documentId = documentId)
            createOrUpdateQrCode(documentId)
        }
    }

    private fun createOrUpdateQrCode(documentId: String) {
        val jwt = generateJwt(documentId)
        println(jwt)
        generateQrCode(jwt, QR_CODE_WIDTH, QR_CODE_HEIGHT).let { qrCode ->
            _state.value = state.value.copy(documentQrCode = qrCode)
        }
        resetTimer()
    }

    private fun generateJwt(documentId: String): String {
        //TODO: Store secret in a secure place
        val algorithm = Algorithm.HMAC256("secret")
        return JWT.create()
            .withIssuer("ID4You")
            .withClaim("documentId", documentId)
            .withIssuedAt(Date(System.currentTimeMillis()))
            .withExpiresAt(Date(System.currentTimeMillis() + JWT_EXPIRATION_TIME))
            .sign(algorithm)
    }

    private fun generateQrCode(text: String, width: Int, height: Int): Bitmap {
        val hints = mapOf(
            EncodeHintType.ERROR_CORRECTION to ErrorCorrectionLevel.L,
            EncodeHintType.CHARACTER_SET to "UTF-8"
        )

        val bitMatrix = QRCodeWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints)

        return Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565).apply {
            for (x in 0 until width) {
                for (y in 0 until height) {
                    setPixel(x, y, if (bitMatrix[x, y]) Color.BLACK else Color.WHITE)
                }
            }
        }
    }

    private fun resetTimer() {
        countDownTimer?.cancel()
        countDownTimer = object : CountDownTimer(JWT_EXPIRATION_TIME.toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val remainingTime = (millisUntilFinished / 1000).toInt()
                _state.value = _state.value.copy(qrCodeRemainingTime = remainingTime)
            }

            override fun onFinish() {
                _state.value = _state.value.copy(qrCodeRemainingTime = 0)
                createOrUpdateQrCode(_state.value.documentId)
            }
        }.start()
    }

    fun onEvent(event: DocumentQrEvent) {
        when (event) {
            DocumentQrEvent.RegenerateQrCode -> {
                state.value.documentId.let { documentId ->
                    createOrUpdateQrCode(documentId)
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        countDownTimer?.cancel()
    }
}
