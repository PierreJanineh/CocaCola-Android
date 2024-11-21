package com.pierrejanineh.cocacola.ui.base

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.pierrejanineh.cocacola.utils.LocaleManager

abstract class BaseActivity : AppCompatActivity() {
    override fun attachBaseContext(newBase: Context?) {
        newBase?.let {
            super.attachBaseContext(LocaleManager.setAppLocale(it))
        }
    }
}