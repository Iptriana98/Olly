package com.iptriana.olly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.iptriana.olly.ui.components.OllyTabRow
import com.iptriana.olly.ui.navigation.OllyNavHost
import com.iptriana.olly.ui.navigation.OllyTabRowScreens
import com.iptriana.olly.ui.navigation.Overview
import com.iptriana.olly.ui.navigation.navigateSingleTopTo
import com.iptriana.olly.ui.theme.OllyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OllyApp()
        }
    }
}

@Composable
fun OllyApp() {
    OllyTheme {
        val navController = rememberNavController()
        val currentBackstack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackstack?.destination
        val currentScreen =
            OllyTabRowScreens.find { it.route == currentDestination?.route } ?: Overview
        Scaffold(
            topBar = {
                OllyTabRow(
                    allScreens = OllyTabRowScreens,
                    onTabSelected = { screen ->
                        navController.navigateSingleTopTo(screen.route)
                    },
                    currentScreen = currentScreen
                )
            }
        ) { innerPadding ->
            OllyNavHost(navController = navController, modifier = Modifier.padding(innerPadding))
        }
    }
}