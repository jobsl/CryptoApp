package com.point56.android.cryptoapp.di

import androidx.lifecycle.ViewModel
import com.point56.android.cryptoapp.presentation.CoinViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CoinViewModel::class)
    fun bindCoinViewModule(viewModel: CoinViewModel): ViewModel

}