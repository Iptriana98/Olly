package com.iptriana.olly.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.MoneyOff
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.ui.graphics.vector.ImageVector


/**
 * Contract for information needed on every Olly navigation destination
 */
interface OllyDestination {
    val icon: ImageVector
    val route: String
}

/**
 * Olly app navigation destinations
 */
object Overview : OllyDestination {
    override val icon = Icons.Filled.PieChart
    override val route = "overview"
}

object Accounts : OllyDestination {
    override val icon = Icons.Filled.AttachMoney
    override val route = "accounts"
}

object Bills : OllyDestination {
    override val icon = Icons.Filled.MoneyOff
    override val route = "bills"
}

//object SingleAccount : OllyDestination {
//    override val icon = Icons.Filled.Money
//    override val route = "single_account"
//    const val accountTypeArg = "account_type"
//    val routeWithArgs = "$route/{$accountTypeArg}"
//    val arguments = listOf(
//        navArgument(accountTypeArg) { type = NavType.StringType }
//    )
//    val deepLinks = listOf(
//        navDeepLink { uriPattern = "Olly://$route/{$accountTypeArg}" }
//    )
//}

// Screens to be displayed in the top OllyTabRow
val OllyTabRowScreens = listOf(Overview, Accounts, Bills)
