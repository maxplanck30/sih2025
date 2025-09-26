package com.example.bustrackerappprototype.clean_arcitecture.presentation.screens.commuterScreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun BusTrackingScreen() {

    Box(Modifier.fillMaxSize()) {
        Text("Tack Bus",
            Modifier.align(Alignment.Center)
        )
    }

}
