package com.prod.draftforprod.common.di

import com.prod.draftforprod.presentation.viewModels.AuthViewModel
import com.prod.draftforprod.presentation.viewModels.SettingsViewModel
import org.koin.dsl.module
import kotlin.math.sin

val viewModelModule = module {

    single { AuthViewModel(get(), get(), get()) }

    single { SettingsViewModel(get(), get(), get()) }
}