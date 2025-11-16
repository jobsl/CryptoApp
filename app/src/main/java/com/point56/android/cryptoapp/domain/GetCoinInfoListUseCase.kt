package com.point56.android.cryptoapp.domain

import javax.inject.Inject

class GetCoinInfoListUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke() = repository.getCoinInfoList()

}