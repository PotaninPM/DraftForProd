package com.prod.draftforprod.domain.repository

import com.prod.draftforprod.data.remote.dto.auth.AuthResponse
import com.prod.draftforprod.domain.model.UserProfile

interface AuthRepository {
    suspend fun register(email: String, password: String): Boolean
    suspend fun login(email: String, password: String): Boolean

    fun getToken(): String?
    fun clearToken()
}