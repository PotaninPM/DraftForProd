package com.prod.draftforprod.ui.navigation

sealed class Screen(val route: String) {
    data object MainScreen : Screen("main_screen")
    data object HomeScreen : Screen("home_screen")
}