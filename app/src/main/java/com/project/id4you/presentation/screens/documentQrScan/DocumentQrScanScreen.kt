package com.project.id4you.presentation.screens.documentQrScan

import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.project.id4you.common.TestTags
import com.project.id4you.presentation.components.ErrorText
import com.project.id4you.presentation.components.LoadingIndicator
import com.project.id4you.presentation.components.text.TextComponent
import com.project.id4you.presentation.components.text.TextType

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun DocumentQrScanScreen(
    state: DocumentQrScanState,
    onNavigateToDocumentDetailScreen: (String) -> Unit,
    onEvent: (DocumentQrScanEvent) -> Unit
) {
    val cameraPermissionState = rememberPermissionState(android.Manifest.permission.CAMERA)

    if (cameraPermissionState.status.isGranted) {
        CameraScreen(onEvent, state, onNavigateToDocumentDetailScreen)
    } else if (cameraPermissionState.status.shouldShowRationale) {
        CameraPermissionErrorText(errorMessage = "Camera permission permanently denied")
    } else {
        SideEffect {
            cameraPermissionState.run { launchPermissionRequest() }
        }
        CameraPermissionErrorText(errorMessage = "No camera permission.")
    }
}

@Composable
fun CameraPermissionErrorText(errorMessage: String) {
    Box() {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 50.dp)
        ) {
            TextComponent(labelText = errorMessage, textType = TextType.REGULAR)
        }
    }
}

@Composable
fun CameraScreen(
    onEvent: (DocumentQrScanEvent) -> Unit,
    state: DocumentQrScanState,
    onNavigateToDocumentDetailScreen: (String) -> Unit
) {
    val localContext = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraProviderFuture = remember {
        ProcessCameraProvider.getInstance(localContext)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AndroidView(
            modifier = Modifier
                .fillMaxSize(),
            factory = { context ->
                val previewView = PreviewView(context)
                val preview = Preview.Builder().build()
                val selector = CameraSelector.Builder()
                    .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                    .build()

                preview.setSurfaceProvider(previewView.surfaceProvider)

                val imageAnalysis = ImageAnalysis.Builder().build()
                imageAnalysis.setAnalyzer(
                    ContextCompat.getMainExecutor(context), QrCodeAnalyzer(onEvent)
                )

                runCatching {
                    cameraProviderFuture.get().bindToLifecycle(
                        lifecycleOwner,
                        selector,
                        preview,
                        imageAnalysis
                    )
                }.onFailure {
                    Log.e("CAMERA", "Camera bind error ${it.localizedMessage}", it)
                }
                previewView
            }
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black.copy(alpha = 0.5f)),
        )

        Box(
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.Center)
                .background(
                    color = Color.White.copy(alpha = 0.1f),
                    shape = RoundedCornerShape(8.dp)
                )
        )

        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 40.dp)
        ) {
            TextComponent(
                labelText = "Scan QR Code",
                textType = TextType.HEADER_WHITE,
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 240.dp)
        ) {
            TextComponent(
                labelText = "Place QR Code inside the frame",
                textType = TextType.SMALL_WHITE,
            )
        }

        if (state.error.isNotBlank()) {
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 60.dp),
            ) {
                ErrorText(errorMessage = state.error, contentAlignment = Alignment.BottomCenter)
            }
        }

        if (state.isLoading) {
            LoadingIndicator(modifier = Modifier.testTag(TestTags.LOADING_COMPONENT))
        }

        if (state.isSuccess) {
            LaunchedEffect(Unit) {
                onNavigateToDocumentDetailScreen(state.documentId)
            }
        }
    }
}
