package com.bigdream.presentation.ui.navigation

// Each object represents a destination in the app.
// The "route" string is what Navigation Compose uses to navigate between screens.
sealed class Screen(val route: String) {
    data object Login : Screen("login")
    data object Register : Screen("register")
    data object Feed : Screen("feed")
    data object Profile : Screen("profile")
    data object Connections : Screen("connections")
}
