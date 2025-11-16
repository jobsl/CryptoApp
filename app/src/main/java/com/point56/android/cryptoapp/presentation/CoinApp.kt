package com.point56.android.cryptoapp.presentation

import android.app.Application
import androidx.work.Configuration
import com.point56.android.cryptoapp.data.database.AppDatabase
import com.point56.android.cryptoapp.data.mapper.CoinMapper
import com.point56.android.cryptoapp.data.network.ApiFactory
import com.point56.android.cryptoapp.data.workers.RefreshDataWorkerFactory
import com.point56.android.cryptoapp.di.DaggerApplicationComponent

class CoinApp : Application(), Configuration.Provider {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(
                RefreshDataWorkerFactory(
                    AppDatabase.getInstance(this).coinPriceInfoDao(),
                    ApiFactory.apiService,
                    CoinMapper()
                )
            )
            .build()
}