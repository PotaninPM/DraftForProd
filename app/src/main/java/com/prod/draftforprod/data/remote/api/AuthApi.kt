package com.prod.draftforprod.data.remote.api

import com.prod.draftforprod.data.remote.dto.UserProfileDto
import com.prod.draftforprod.data.remote.dto.auth.AuthResponse
import com.prod.draftforprod.data.remote.dto.auth.LoginRequestDto
import com.prod.draftforprod.data.remote.dto.auth.RegisterRequestDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/register")
    suspend fun register(@Body request: RegisterRequestDto): AuthResponse

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequestDto): AuthResponse

    @GET("user/profile")
    suspend fun getProfile(): UserProfileDto
}