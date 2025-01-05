package com.prod.draftforprod.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.text.intl.LocaleList
import androidx.core.os.LocaleListCompat
import com.prod.draftforprod.presentation.models.ThemeSetting
import com.prod.draftforprod.presentation.screens.RootNavigation
import com.prod.draftforprod.presentation.ui.theme.DraftForProdTheme
import com.prod.draftforprod.presentation.viewModels.SettingsViewModel
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoinAndroidContext {
                val settingsViewModel: SettingsViewModel = koinViewModel()

                val theme = settingsViewModel.themeSetting.value.collectAsState().value ?: return@KoinAndroidContext
                val dc = settingsViewModel.dcSetting.value.collectAsState().value ?: return@KoinAndroidContext
                val langSetting = settingsViewModel.langSetting.value.collectAsState().value ?: return@KoinAndroidContext

                LaunchedEffect(langSetting) {
                    val locale =
                        if (langSetting.locale != null) LocaleListCompat.forLanguageTags(langSetting.locale)
                        else LocaleListCompat.getEmptyLocaleList()

                    AppCompatDelegate.setApplicationLocales(locale)
                    this@MainActivity.recreate()
                }

                DraftForProdTheme(
                    darkTheme = when (theme) {
                        ThemeSetting.LIGHT -> false
                        ThemeSetting.DARK -> true
                        ThemeSetting.SYSTEM -> isSystemInDarkTheme()
                    },
                    dynamicColor = dc
                ) {
                    RootNavigation()
                }
            }
        }
    }
}
