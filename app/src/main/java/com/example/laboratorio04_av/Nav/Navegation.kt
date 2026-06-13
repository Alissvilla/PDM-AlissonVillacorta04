package com.example.laboratorio04_av.Nav

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio04_av.View.TaskScreen
import com.example.laboratorio04_av.ViewModel.GeneralViewModel
import com.example.laboratorio04_av.ui.theme.Inicio

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val generalViewModel: GeneralViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "Inicio"
    ) {
        composable("Inicio") {
            Inicio(
                navController = navController,
                viewModel = generalViewModel
            )
        }

        composable("Greeting") {
            TaskScreen(
                viewModel = generalViewModel
            )
        }
    }
}