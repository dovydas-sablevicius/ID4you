package com.project.id4you.presentation.screens.documentDetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.project.id4you.data.repository.model.Document

@Composable
fun InformationSection(modifier: Modifier = Modifier, document: Document) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        AttributeInformation(attributeName = "Name", attributeValue = document.name)
        AttributeInformation(attributeName = "Type", attributeValue = document.type)
        AttributeInformation(
            attributeName = "Valid Until",
            attributeValue = document.validUntil
        )
        AttributeInformation(
            attributeName = "Document Code",
            attributeValue = document.documentCode
        )
        if (document.driverLicenseCategory.isNotEmpty()) {
            for (category in document.driverLicenseCategory) {
                AttributeInformation(
                    attributeName = "Category",
                    attributeValue = category
                )
            }
        }
    }
}