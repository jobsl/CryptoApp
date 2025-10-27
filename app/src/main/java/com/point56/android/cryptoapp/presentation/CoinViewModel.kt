package com.point56.android.cryptoapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.point56.android.cryptoapp.data.repository.CoinRepositoryImpl
import com.point56.android.cryptoapp.domain.GetCoinInfoListUseCase
import com.point56.android.cryptoapp.domain.GetCoinInfoUseCase
import com.point56.android.cryptoapp.domain.LoadDataUseCase

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)

    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        loadDataUseCase()
    }
}