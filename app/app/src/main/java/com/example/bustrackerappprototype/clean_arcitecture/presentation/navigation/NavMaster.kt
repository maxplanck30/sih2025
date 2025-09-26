package com.example.bustrackerappprototype.clean_arcitecture.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bustrackerappprototype.clean_arcitecture.presentation.App
import com.example.bustrackerappprototype.clean_arcitecture.presentation.screens.commuterScreens.Commuter_MainScreen
import com.example.bustrackerappprototype.clean_arcitecture.presentation.screens.loginScreen.LoginScreen_Commuter
import com.example.bustrackerappprototype.clean_arcitecture.presentation.screens.loginScreen.LoginScreen_Driver


@Composable
fun NavMaster(
    navController: NavHostController = rememberNavController()
){

    NavHost(
        navController = navController,
        startDestination = Home
    ){

        composable<Home> {
            App(
                onClickDriver = { navController.navigate(D_Log)},
                onClickCommuter = { navController.navigate(C_Log)}
            )
        }

        composable<D_Log> {
            LoginScreen_Driver(onclick = { navController.navigate(D_Main) })

        }
        composable<C_Log> {
            LoginScreen_Commuter(onclick = {navController.navigate(C_Main)})
        }



        composable<D_Main> {

            Box(Modifier.fillMaxSize().background(color = Color.Red))

        }
        composable<C_Main> {
            Commuter_MainScreen()
        }




          composable<SplashScreen> {

        }




    }

}
