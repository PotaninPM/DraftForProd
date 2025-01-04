package com.prod.draftforprod.presentation.screens

import kotlinx.serialization.Serializable

sealed class RootNavDestinations {

    @Serializable
    object Welcome : RootNavDestinations()

    @Serializable
    object Home : RootNavDestinations()
}