package com.prod.draftforprod.common.di

import com.prod.draftforprod.domain.usecases.LoginUseCase
import com.prod.draftforprod.domain.usecases.RegisterUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { LoginUseCase(get()) }
    single { RegisterUseCase(get()) }
}