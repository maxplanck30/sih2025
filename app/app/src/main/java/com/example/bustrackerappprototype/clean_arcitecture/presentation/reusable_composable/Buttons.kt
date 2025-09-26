package com.example.bustrackerappprototype.clean_arcitecture.presentation.reusable_composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bustrackerappprototype.ui.theme.NeutralLight
import com.example.bustrackerappprototype.ui.theme.Primary


@Composable
fun Btn_LogScreen(
    onclick: () -> Unit ,
    text: String = "text",
    TextColor: Color = NeutralLight,
    containerColor: Color = Primary
){

    Button(onClick =  onclick  ,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
        ),
        shape = RoundedCornerShape(22),
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
    )
    {
        Text(
            text,
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold,
            color = TextColor,
        )
    }


}