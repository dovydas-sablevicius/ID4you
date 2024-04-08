package com.project.id4you.presentation.screens.documentQr

import androidx.lifecycle.SavedStateHandle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowBitmap

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [29], shadows = [ShadowBitmap::class])
class DocumentQrViewModelTest {
    private lateinit var savedStateHandle: SavedStateHandle
    private lateinit var documentQrViewModel: DocumentQrViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        savedStateHandle = SavedStateHandle()
        documentQrViewModel = DocumentQrViewModel(savedStateHandle)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun qrCodeIsCreated_whenNoExistingQrCode() {
        val documentId = "testDocumentId"
        documentQrViewModel.createOrUpdateQrCode(documentId)
        val qrCode = documentQrViewModel.state.value.documentQrCode
        assert(qrCode != null)
    }

    @Test
    fun qrCodeIsUpdated_whenExistingQrCode() {
        val documentId = "testDocumentId"
        documentQrViewModel.createOrUpdateQrCode(documentId)
        val qrCode1 = documentQrViewModel.state.value.documentQrCode
        documentQrViewModel.createOrUpdateQrCode(documentId)
        val qrCode2 = documentQrViewModel.state.value.documentQrCode
        assert(qrCode1 != qrCode2)
    }

    @Test
    fun qrCodeIsRegenerated_whenRegenerateEventIsTriggered() {
        val documentId = "testDocumentId"
        documentQrViewModel.createOrUpdateQrCode(documentId)
        val qrCode1 = documentQrViewModel.state.value.documentQrCode
        documentQrViewModel.onEvent(DocumentQrEvent.RegenerateQrCode)
        val qrCode2 = documentQrViewModel.state.value.documentQrCode
        assert(qrCode1 != qrCode2)
    }

    @Test
    fun qrCodeTimerIsReset_whenQrCodeIsCreated() {
        val documentId = "testDocumentId"
        documentQrViewModel.createOrUpdateQrCode(documentId)
        val remainingTime1 = documentQrViewModel.state.value.qrCodeRemainingTime
        Thread.sleep(2000)
        documentQrViewModel.createOrUpdateQrCode(documentId)
        val remainingTime2 = documentQrViewModel.state.value.qrCodeRemainingTime
        assert(remainingTime1 <= remainingTime2)
    }
}