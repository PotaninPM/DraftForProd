package com.prod.draftforprod.presentation.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavBar(
    navController: NavHostController,
    destinations: List<BottomNavItem<*>>
) {
    NavigationBar(
        modifier = Modifier.height(70.dp)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        destinations.forEach { destination ->
            val isSelected: Boolean = currentDestination?.hasRoute(destination.route::class) ?: false

            NavigationBarItem(
                selected = isSelected, 
                onClick = {
                    navController.navigate(destination.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(if (isSelected) destination.selectedIconRes else destination.unselectedIconRes),
                        contentDescription = stringResource(id = destination.labelRes)
                    )
                },
                label = {
                    Text(text = stringResource(id = destination.labelRes))
                }
            )
        }
    }
}