package com.example.domain.coroutines

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


abstract class BaseCoroutinesUseCase<Results, in Params>(
    executionDispatcher: CoroutineDispatcher
) : BaseUseCase(executionDispatcher) {

    abstract suspend fun buildUseCase(params: Params? = null): Results

    suspend fun execute(params: Params? = null): Result<Results> =
        withContext(dispatcher) {
            try {
                if (dispatcher == Dispatchers.Main)
                    throw RuntimeException("Use case '${this::class.simpleName}' cannot be executed in $dispatcher")

                resultOf {
                    this@BaseCoroutinesUseCase.buildUseCase(params)
                }
            } catch (t: Throwable) {
                logException(t.message ?: t.cause?.message ?: t.toString())
                Result.failure(t)
            } catch (e: Exception) {
                logException(e.localizedMessage ?: e.cause?.message ?: e.toString())
                Result.failure(Throwable(e.localizedMessage))
            }
        }


    override fun logException(errMessage: String) {
        Log.e(this::class.simpleName, "${this::class.simpleName} : $errMessage")

    }
}