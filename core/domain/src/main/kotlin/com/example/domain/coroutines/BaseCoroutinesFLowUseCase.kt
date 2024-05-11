
package com.example.domain.coroutines

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map


abstract class BaseCoroutinesFLowUseCase<Results, in Params>(
    executionDispatcher: CoroutineDispatcher
) : BaseUseCase(executionDispatcher) {

    abstract suspend fun buildUseCaseFlow(params: Params? = null): Flow<Results>

    suspend fun execute(params: Params? = null): Flow<Result<Results>> =
        try {
            if (dispatcher == Dispatchers.Main)
                throw RuntimeException("Use case '${this::class.simpleName}' cannot be executed in $dispatcher")

            this.buildUseCaseFlow(params)
                .flowOn(dispatcher)
                .map {
                    resultOf { it }
                }
        } catch (e: Exception) {
            logException(e.localizedMessage ?: e.cause?.message ?: e.toString())
            flowOf(Result.failure(Throwable(e.localizedMessage)))
        } catch (t: Throwable) {
            logException(t.message ?: t.cause?.message ?: t.toString())
            flowOf(Result.failure(t))
        }

    override fun logException(errMessage: String) {
        Log.e(this::class.simpleName, "${this::class.simpleName} : $errMessage")
    }
}