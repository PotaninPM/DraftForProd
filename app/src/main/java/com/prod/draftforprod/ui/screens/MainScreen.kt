package com.prod.draftforprod.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.prod.draftforprod.ui.navigation.BottomNavItem
import com.prod.draftforprod.ui.navigation.Screen
import com.prod.draftforprod.R
import com.prod.draftforprod.ui.navigation.AppNavBar
import com.prod.draftforprod.ui.navigation.AppNavHost

@Composable
fun MainScreen() {
    val topLevelDestinations = listOf(
        BottomNavItem(
            route = Screen.HomeScreen.route,
            labelRes = R.string.main,
            selectedIcon = Icons.Filled.Menu,
            unselectedIcon = Icons.Outlined.Menu
        ),
//        BottomNavItem(
//            route = Screen.FavScreen.route,
//            labelRes = R.string.favourite,
//            selectedIcon = Icons.Filled.Favorite,
//            unselectedIcon = Icons.Outlined.FavoriteBorder
//        )
    )

    val localNavController = rememberNavController()
    val currentRoute = localNavController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute in topLevelDestinations.map { it.route }) {
                AppNavBar(
                    navController = localNavController,
                    destinations = topLevelDestinations
                )
            }
        },
        contentWindowInsets = WindowInsets(0.dp)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            AppNavHost(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                navController = localNavController
            )
        }
    }
}