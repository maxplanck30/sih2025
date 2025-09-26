package com.example.bustrackerappprototype.clean_arcitecture.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bustrackerappprototype.clean_arcitecture.presentation.reusable_composable.Btn_LogScreen
import com.example.bustrackerappprototype.ui.theme.NeutralLight


@Composable
fun App(modifier: Modifier = Modifier,
        onClickDriver: ()-> Unit ,
        onClickCommuter: ()-> Unit
) {

    MaterialTheme {

        Column(
            modifier = modifier
                .fillMaxSize()
                .background(
                    color = NeutralLight,
                    shape = RoundedCornerShape(12)
                )
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {

// Login Buttons
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(32.dp),
                modifier = Modifier
            ) {
                Btn_LogScreen(text = "SignUp As Driver",
                    onclick =  onClickDriver
                )
                Btn_LogScreen(text = "SignUp As Commuter",
                    onclick = onClickCommuter
                              )
            }




        }

    }

}
