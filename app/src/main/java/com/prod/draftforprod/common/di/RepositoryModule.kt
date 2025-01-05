package com.prod.draftforprod.common.di

import com.prod.draftforprod.data.repository.AuthRepositoryImpl
import com.prod.draftforprod.data.repository.SettingsRepositoryImpl
import com.prod.draftforprod.domain.repository.AuthRepository
import com.prod.draftforprod.domain.repository.SettingsRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }

    single<SettingsRepository> { SettingsRepositoryImpl(get()) }
}