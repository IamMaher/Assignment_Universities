package com.example.domain.coroutines

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Base UseCase
 *
 * Created on Sep 12, 2022.
 *
 */
abstract class BaseUseCase(
    executionDispatcher: CoroutineDispatcher
) {
    protected val dispatcher = executionDispatcher

    abstract fun logException(errMessage: String)
}