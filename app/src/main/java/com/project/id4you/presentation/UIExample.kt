package com.project.id4you.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class UIExample {

    @Composable
    fun MainContent() {
        Column {
            textField()
            outlinedTextField()
            Row {
                buttons()
            }
            for (index in 1..3) {
                listItem(number = index)
            }
        }
    }
    @Composable
    fun textField() {
        Text(text = "Enter your name:")
        TextField(
            value = "",
            onValueChange = { /* Handle changes */ },
            label = { Text("Enter your name") },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                //.background(color = Color.LightGray)
                .clip(RoundedCornerShape(8.dp))
        )
    }

    @Composable
    fun outlinedTextField() {
        OutlinedTextField(
            value = "",
            onValueChange = { /* Handle changes */ },
            label = { Text("Enter your name") }, // Set your label text here
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }

    @Composable
    fun buttons() {
        Button(
            onClick = { /* Handle button click */ },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .background(color = Color.LightGray),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White // Set your desired text color
            )
        ) {
            Text("Click Me") // Button content
        }
//    ElevatedButton(
//        onClick = { /* Handle button click */ },
//        //modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
//    ) {
//        Text("Click Me") // Button content
//    }
//
//    FilledTonalButton(
//        onClick = { /* Handle button click */ },
//        //modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
//    ) {
//        Text("Click Me") // Button content
//    }
//
//    OutlinedButton(
//        onClick = { /* Handle button click */ },
//        //modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
//    ) {
//        Text("Click Me") // Button content
//    }

        FloatingActionButton(
            onClick = { /* Your action here */ },
            content = {
                Icon(Icons.Filled.Add, contentDescription = "Add something")
            }
        )
    }

    @Composable
    fun listItem(number: Number) {
        ListItem(
            headlineContent = { Text("Item Name $number") },
            overlineContent = { Text("Category: Office Supplies") },
            supportingContent = {
                Text("In stock: 5 units") // Additional details
            },
            trailingContent = {
                IconButton(onClick = { /* Delete task */ }) {
                    Icon(Icons.Filled.Delete, contentDescription = "Delete Task")
                }
            },
            //tonalElevation = 4.dp,
            shadowElevation = 24.dp
        )
    }
}