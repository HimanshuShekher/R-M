package com.example.rm.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rm.ui.theme.CharacterDetailScreen
import com.example.rm.ui.theme.CharacterListScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "character_list") {
        composable("character_list") {
            CharacterListScreen(navController)
        }
        composable("character_detail/{characterId}") { backStackEntry ->
            val characterId = backStackEntry.arguments?.getString("characterId")?.toInt() ?: 0
            CharacterDetailScreen(navController, characterId)
        }
    }
}
