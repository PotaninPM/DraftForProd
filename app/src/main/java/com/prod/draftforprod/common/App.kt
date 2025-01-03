package com.prod.draftforprod.common

import android.app.Application
import com.prod.draftforprod.common.di.commonModule
import com.prod.draftforprod.common.di.networkModule
import com.prod.draftforprod.common.di.repositoryModule
import com.prod.draftforprod.common.di.roomModule
import com.prod.draftforprod.common.di.useCaseModule
import com.prod.draftforprod.common.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

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