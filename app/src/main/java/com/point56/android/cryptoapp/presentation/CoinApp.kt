package com.point56.android.cryptoapp.presentation

import android.app.Application
import com.point56.android.cryptoapp.di.DaggerApplicationComponent

class CoinApp : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

}