package com.pierrejanineh.cocacola.utils

import android.content.Context
import android.os.LocaleList
import java.util.Locale

object LocaleManager {
    fun setAppLocale(context: Context): Context {
        val hebrewLocale = Locale("he")
        Locale.setDefault(hebrewLocale)

        val resources = context.resources
        val config = resources.configuration

        config.setLocale(hebrewLocale)
        config.setLocales(LocaleList(hebrewLocale))

        return context.createConfigurationContext(config)
    }
}