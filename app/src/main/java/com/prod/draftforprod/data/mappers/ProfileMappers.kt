package com.prod.draftforprod.data.mappers

import com.prod.draftforprod.domain.model.UserProfile
import com.prod.draftforprod.data.remote.dto.UserProfileDto

fun UserProfileDto.toDomainUser(): UserProfile {
    return UserProfile(
        id = this.id,
        avatar = this.avatar,
        email = this.email,
        name = this.name
    )
}