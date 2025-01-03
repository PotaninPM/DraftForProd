package com.prod.draftforprod.common.di

import com.prod.draftforprod.presentation.viewModels.AuthViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel() { AuthViewModel(get(), get(), get()) }
}