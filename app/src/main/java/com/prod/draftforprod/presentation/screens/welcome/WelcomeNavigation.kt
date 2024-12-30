package com.prod.draftforprod.presentation.screens.welcome

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prod.draftforprod.presentation.screens.welcome.login.LoginScreen
import com.prod.draftforprod.presentation.screens.welcome.register.RegisterScreen
import com.prod.draftforprod.presentation.screens.welcome.welcome.WelcomeScreen

@Composable
fun WelcomeNavigation(rootNavController: NavHostController) {
    val welcomeNavController = rememberNavController()

    Scaffold { innerPadding ->
        NavHost(
            navController = welcomeNavController,
            modifier = Modifier.padding(innerPadding),
            startDestination = WelcomeNavDestinations.Welcome,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
            popEnterTransition = { EnterTransition.None },
            popExitTransition = { ExitTransition.None }
        ) {

            composable<WelcomeNavDestinations.Welcome> {
                WelcomeScreen(
                    welcomeNavController = welcomeNavController
                )
            }

            composable<WelcomeNavDestinations.Register> {
                RegisterScreen(
                    rootNavController = rootNavController
                )
            }

            composable<WelcomeNavDestinations.Login> {
                LoginScreen(
                    rootNavController = rootNavController
                )
            }
        }
    }
}