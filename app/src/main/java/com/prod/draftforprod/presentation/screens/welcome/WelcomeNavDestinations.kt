package com.prod.draftforprod.presentation.screens.welcome

sealed class WelcomeNavDestinations {

    object Welcome : WelcomeNavDestinations()

    object Login : WelcomeNavDestinations()

    object Register : WelcomeNavDestinations()
}