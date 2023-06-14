package com.powilliam.reimaginedoctomeme.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.powilliam.reimaginedoctomeme.instructions.InstructionsScreen

@Composable
fun ApplicationNavHost(
    windowSizeClass: WindowSizeClass,
    controller: NavHostController = rememberNavController()
) {
    NavHost(navController = controller, startDestination = Destination.Instructions.route) {
        composable(Destination.Instructions.route, Destination.Instructions.arguments) {
            InstructionsScreen()
        }
    }
}