package com.prod.draftforprod.data.repository

import android.content.SharedPreferences
import com.prod.draftforprod.data.mappers.toDomainUser
import com.prod.draftforprod.data.remote.api.AuthApi
import com.prod.draftforprod.data.remote.dto.auth.AuthResponse
import com.prod.draftforprod.data.remote.dto.auth.LoginRequestDto
import com.prod.draftforprod.data.remote.dto.auth.RegisterRequestDto
import com.prod.draftforprod.domain.model.UserProfile
import com.prod.draftforprod.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val api: AuthApi,
    private val prefs: SharedPreferences
) : AuthRepository {
    override suspend fun register(email: String, password: String): Boolean {
        val response = api.register(RegisterRequestDto(email, password))
        return handleAuthResponse(response)
    }

    override suspend fun login(email: String, password: String): Boolean {
        val response = api.login(LoginRequestDto(email, password))
        return handleAuthResponse(response)
    }

    private fun handleAuthResponse(response: AuthResponse): Boolean {
        saveToken(response.token)
        return true
    }

    private fun saveToken(token: String) {
        prefs.edit().putString("jwt_token", token).apply()
    }

    override suspend fun getProfile(): UserProfile {
        val profileDto = api.getProfile()
        return profileDto.toDomainUser()
    }

    override fun getToken(): String? {
        return prefs.getString("jwt_token", null)
    }

    override fun clearToken() {
        prefs.edit().remove("jwt_token").apply()
    }
}