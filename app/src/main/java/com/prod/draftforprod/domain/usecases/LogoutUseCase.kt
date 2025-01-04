package com.prod.draftforprod.domain.usecases

import com.prod.draftforprod.domain.repository.AuthRepository

class LogoutUseCase(private val repository: AuthRepository) {
    operator fun invoke() {
        return repository.clearToken()
    }
}