package com.prod.draftforprod.common.di

import com.prod.draftforprod.presentation.viewModels.AuthViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { AuthViewModel(get(), get(), get()) }
}