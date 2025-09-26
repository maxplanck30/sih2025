package com.example.bustrackerappprototype.clean_arcitecture.presentation.screens.loginScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bustrackerappprototype.R
import com.example.bustrackerappprototype.clean_arcitecture.presentation.reusable_composable.Btn_LogScreen
import com.example.bustrackerappprototype.clean_arcitecture.presentation.reusable_composable.CustomNumberTextField
import com.example.bustrackerappprototype.ui.theme.NeutralDark


@Preview
@Composable
fun LoginScreen_Driver(modifier: Modifier = Modifier, 
                       onclick: () -> Unit = {}){
    var text by remember { mutableStateOf("Enter Your Number") }
    Column(Modifier
        .fillMaxSize()
        .background(Color(0xFFFFFFFF))
        .padding(horizontal = 32.dp)
        .padding(top = 100.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

            Image(painter = painterResource(R.drawable.driver2_img),
                contentDescription = null,
                modifier = Modifier.size(450.dp)
            )

        Box(Modifier.fillMaxWidth()
            .height(70.dp)
            .background(shape = RoundedCornerShape(22),
                color = NeutralDark.copy(alpha = .7f)
            )){
            CustomNumberTextField()
        }

        Btn_LogScreen(onclick = onclick,
            text = "Log In")

    }

}










