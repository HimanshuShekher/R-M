package com.example.rm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController

import com.example.rm.ui.theme.RMTheme
import com.example.rm.ui.theme.navigation.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RMTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                AppNavigation(navController)
            }
        }
    }
}

