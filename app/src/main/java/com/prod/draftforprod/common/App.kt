package com.prod.draftforprod.common

import android.app.Application
import android.content.Context
import com.prod.draftforprod.common.di.commonModule
import com.prod.draftforprod.common.di.networkModule
import com.prod.draftforprod.common.di.repositoryModule
import com.prod.draftforprod.common.di.roomModule
import com.prod.draftforprod.common.di.useCaseModule
import com.prod.draftforprod.common.di.viewModelModule
import com.prod.draftforprod.data.remote.api.AuthApi
import com.prod.draftforprod.data.repository.AuthRepositoryImpl
import com.prod.draftforprod.domain.repository.AuthRepository
import com.prod.draftforprod.domain.usecases.LoginUseCase
import com.prod.draftforprod.domain.usecases.LogoutUseCase
import com.prod.draftforprod.domain.usecases.RegisterUseCase
import com.prod.draftforprod.presentation.viewModels.AuthViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = listOf(
    viewModelModule,
    networkModule,
    repositoryModule,
    useCaseModule,
    roomModule,
    commonModule
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