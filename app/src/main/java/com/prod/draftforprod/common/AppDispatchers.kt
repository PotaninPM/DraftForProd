package com.prod.draftforprod.common

import kotlinx.coroutines.CoroutineDispatcher

class AppDispatchers(
    val ui: CoroutineDispatcher,
    val io: CoroutineDispatcher,
    val default: CoroutineDispatcher,
    val unconfined: CoroutineDispatcher
)