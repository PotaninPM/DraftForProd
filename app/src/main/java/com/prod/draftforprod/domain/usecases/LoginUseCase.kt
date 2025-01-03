package com.prod.draftforprod.domain.usecases

import com.prod.draftforprod.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String) : Boolean {
        return repository.login(email, password)
    }
}