package com.marcelo.buscarcep.ui.theme.nav

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marcelo.buscarcep.ui.theme.view.HomeScreen
import com.marcelo.buscarcep.ui.theme.view.SearchCEPViewModel
import com.marcelo.buscarcep.ui.theme.view.SearchCep

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(navController, startDestination = "searchCep") {

        composable("searchCep") {
            val viewModel: SearchCEPViewModel = hiltViewModel()
            SearchCep(
                viewModel = viewModel,
                navController = navController
            )
        }

        composable("home") {
            HomeScreen()
        }
    }
}