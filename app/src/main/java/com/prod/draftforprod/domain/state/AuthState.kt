package com.prod.draftforprod.domain.state

sealed class AuthState {
    object Loading : AuthState()
    object Authorized : AuthState()
    object Unauthorized : AuthState()
    data class Error(val message: String) : AuthState()
}