package com.prod.draftforprod.presentation.screens.welcome

import kotlinx.serialization.Serializable

sealed class WelcomeNavDestinations {

    @Serializable
    object Welcome : WelcomeNavDestinations()

    @Serializable
    object Login : WelcomeNavDestinations()

    @Serializable
    object Register : WelcomeNavDestinations()
}