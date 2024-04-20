package com.project.id4you.presentation.screens.documentDetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.project.id4you.data.repository.model.Document
import java.time.LocalDate
import java.time.temporal.ChronoUnit

@Composable
fun InformationSection(modifier: Modifier = Modifier, document: Document) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        if (document.documentOwner != null) {
            val birthdate: LocalDate =
                LocalDate.parse(document.documentOwner.birthDate.substringBefore(" "))
            val age: Long = ChronoUnit.YEARS.between(birthdate, LocalDate.now())
            AttributeInformation(
                attributeName = "Age",
                attributeValue = age.toString()
            )
        }
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
