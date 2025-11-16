package com.point56.android.cryptoapp.presentation

import androidx.lifecycle.ViewModel
import com.point56.android.cryptoapp.domain.GetCoinInfoListUseCase
import com.point56.android.cryptoapp.domain.GetCoinInfoUseCase
import com.point56.android.cryptoapp.domain.LoadDataUseCase
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    private val getCoinInfoListUseCase: GetCoinInfoListUseCase,
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    private val loadDataUseCase: LoadDataUseCase
) : ViewModel() {

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        loadDataUseCase()
    }
}