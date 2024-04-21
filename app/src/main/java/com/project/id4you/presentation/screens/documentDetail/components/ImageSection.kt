package com.project.id4you.presentation.screens.documentDetail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.project.id4you.data.repository.model.Document

@Composable
fun ImageSection(
    document: Document,
    imageFetchUrl: String
) {
    if (document.documentPhotos.isNotEmpty()) {
        val imageName: String = document.documentPhotos[0]
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center)
        {
            AsyncImage(
                model = imageFetchUrl + imageName,
                contentDescription = "",
            )
        }
    }
}
