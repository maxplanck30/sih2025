package com.example.bustrackerappprototype.clean_arcitecture.presentation.reusable_composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bustrackerappprototype.ui.theme.TextOnPrimary

@Composable
fun CustomNumberTextField() {
    var text by remember { mutableStateOf("") }

    BasicTextField(
        value = text,
        onValueChange = { input ->
            // Allow only digits
            if (input.all { it.isDigit() }) {
                text = input
            }
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        textStyle = TextStyle(
            color = TextOnPrimary,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .height(60.dp)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        decorationBox = { innerTextField ->
            if (text.isEmpty()) {
                Text(
                    text = "Enter Your Number",
                    color = TextOnPrimary,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            innerTextField()
        }
    )
}
