package com.prod.draftforprod.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlin.reflect.KClass

data class BottomNavItem<T: Any>(
    val route: T,
    @StringRes val labelRes: Int,
    @DrawableRes val selectedIconRes: Int,
    @DrawableRes val unselectedIconRes: Int
)