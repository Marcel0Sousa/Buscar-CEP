package com.marcelo.buscarcep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marcelo.buscarcep.ui.theme.view.SearchCep

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

                val navController: NavHostController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "searchCep"
                ) {
                    composable("searchCep") {
                        SearchCep(navController = navController)
                    }
                }
        }
    }
}