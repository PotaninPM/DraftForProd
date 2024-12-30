package com.prod.draftforprod.presentation.screens.welcome.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun RegisterScreen(rootNavController: NavHostController) {
    RegisterScreenContent()
}

@Composable
private fun RegisterScreenContent() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
    ) {

    }
}

@Preview
@Composable
private fun RegisterScreenDarkPreview() {
    MaterialTheme(
        colorScheme = darkColorScheme()
    ) {
        RegisterScreenContent()
    }
}

@Preview
@Composable
private fun RegisterScreenLightPreview() {
    MaterialTheme(
        colorScheme = lightColorScheme()
    ) {
        RegisterScreenContent()
    }
}