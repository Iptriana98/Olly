package com.iptriana.olly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.iptriana.olly.ui.components.OllyTabRow
import com.iptriana.olly.ui.navigation.OllyTabRowScreens
import com.iptriana.olly.ui.theme.OllyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OllyApp()
        }
    }
}

@Composable
fun OllyApp() {
    OllyTheme {
        Scaffold(
            topBar = {
                OllyTabRow(
                    allScreens = OllyTabRowScreens,
                    onTabSelected = { screen ->
//                        navController.navigateSingleTopTo(screen.route)
                    },
                    currentScreen = /*currentScreen*/ null
                )
            }
        ) { innerPadding ->
            innerPadding
//            RallyNavHost(navController = navController, modifier = Modifier.padding(innerPadding))
        }
    }
}