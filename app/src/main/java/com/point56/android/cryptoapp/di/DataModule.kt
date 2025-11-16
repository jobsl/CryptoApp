package com.point56.android.cryptoapp.di

import android.app.Application
import com.point56.android.cryptoapp.data.database.AppDatabase
import com.point56.android.cryptoapp.data.database.CoinInfoDao
import com.point56.android.cryptoapp.data.network.ApiFactory
import com.point56.android.cryptoapp.data.network.ApiService
import com.point56.android.cryptoapp.data.repository.CoinRepositoryImpl
import com.point56.android.cryptoapp.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideCoinInfoDao(
            application: Application
        ): CoinInfoDao {
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }

}