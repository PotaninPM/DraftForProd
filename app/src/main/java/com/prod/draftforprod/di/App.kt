package com.prod.draftforprod.di

import android.app.Application
import androidx.compose.runtime.Composable
import com.prod.draftforprod.ui.screens.MainScreen
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.compose.KoinContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = listOf(
    networkModule,
    repositoryModule,
    useCaseModule,
    roomModule,
    viewModelModule
)

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(appModule)
        }
    }
}

@Composable
fun App() {
    KoinContext {
        MainScreen()
    }
}