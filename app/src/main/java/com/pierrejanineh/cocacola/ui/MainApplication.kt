package com.pierrejanineh.cocacola.ui

import android.app.Application
import android.content.Context
import com.pierrejanineh.cocacola.utils.LocaleManager

class MainApplication: Application() {
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleManager.setAppLocale(base))
    }
}