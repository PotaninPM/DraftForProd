package com.prod.draftforprod.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.prod.draftforprod.presentation.screens.RootNavigation
import com.prod.draftforprod.presentation.ui.theme.DraftForProdTheme
import org.koin.androidx.compose.KoinAndroidContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoinAndroidContext {
                DraftForProdTheme {
                    RootNavigation()
                }
            }
        }
    }
}
