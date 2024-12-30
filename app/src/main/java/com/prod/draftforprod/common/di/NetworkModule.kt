package com.prod.draftforprod.common.di

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://*.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //single { get<Retrofit>().create(*Api::class.java) }
}