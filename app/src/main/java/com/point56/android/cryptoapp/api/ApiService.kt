package com.point56.android.cryptoapp.api

import com.point56.android.cryptoapp.pojo.CoinInfoListOfData
import com.point56.android.cryptoapp.pojo.CoinPriceInfoRawData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top/totalvolfull")
    fun getTopCoinsInfo(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = API_KEY,
        @Query(QUERY_PARAM_LIMIT) limit: Int = 10,
        @Query(QUERY_PARAM_TO_SYMBOL) tSym: String = CURRENCY

        ): Single<CoinInfoListOfData>

    @GET("pricemultifull")
    fun getFullPriceList(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = API_KEY,
        @Query(QUERY_PARAM_FROM_SYMBOLS) fsyms: String,
        @Query(QUERY_PARAM_TO_SYMBOLS) tsyms: String = CURRENCY

    ): Single<CoinPriceInfoRawData>

companion object {
    private const val QUERY_PARAM_API_KEY = "api_key"
    private const val QUERY_PARAM_LIMIT = "limit"
    private const val QUERY_PARAM_TO_SYMBOL = "tsym"
    private const val QUERY_PARAM_TO_SYMBOLS = "tsyms"

    private const val QUERY_PARAM_FROM_SYMBOLS = "fsyms"

    private const val CURRENCY = "USD"
    private const val API_KEY = "" //79ee9cbe03af138257e72a9fda125d285284600d431b121748455b6c8d699fb4

}


}