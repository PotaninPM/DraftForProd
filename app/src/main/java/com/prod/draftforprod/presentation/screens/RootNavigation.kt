package com.prod.draftforprod.presentation.screens

import android.provider.DocumentsContract.Root
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prod.draftforprod.presentation.screens.home.HomeNavigation
import com.prod.draftforprod.presentation.screens.welcome.WelcomeNavigation

@Composable
fun RootNavigation() {
    val rootNavController = rememberNavController()

    NavHost(
        navController = rootNavController,
        startDestination = RootNavDestinations.Welcome /* или RootNavDestinations.Home если авторизован */,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {

        composable<RootNavDestinations.Home> {
            HomeNavigation(
                rootNavController = rootNavController
            )
        }

        composable<RootNavDestinations.Welcome> {
            WelcomeNavigation(
                rootNavController = rootNavController
            )
        }
    }
}