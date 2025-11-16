package com.point56.android.cryptoapp.data.workers

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import javax.inject.Inject
import javax.inject.Provider

class CoinWorkerFactory @Inject constructor(
    private val workerProviders: @JvmSuppressWildcards Map<Class<out ListenableWorker>, Provider<ChildWorkerFactory>>
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return when (workerClassName) {
            RefreshDataWorker::class.qualifiedName -> {
                val childWorkerFactory = workerProviders[RefreshDataWorker::class.java]?.get()
                childWorkerFactory?.create(appContext, workerParameters)
            }

            else -> null
        }
    }
}

//private val coinInfoDao: CoinInfoDao,
//private val apiService: ApiService,
//private val mapper: CoinMapper