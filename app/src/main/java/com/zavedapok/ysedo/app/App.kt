package com.zavedapok.ysedo.app

import android.app.Application
import android.util.Log
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.appsflyer.AppsFlyerLibCore
import com.zavedapok.ysedo.data.NetworkModule
import com.zavedapok.ysedo.data.Prefs


class App : Application() {


    override fun onCreate() {
        super.onCreate()
        NetworkModule.init()
        Prefs.init(applicationContext)
        initAppsFlyer()
    }
    private fun initAppsFlyer() {
        val conversionDataListener = object : AppsFlyerConversionListener {
            override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
                data?.let { cvData ->
                    cvData.map {
                        Log.i(AppsFlyerLibCore.LOG_TAG, "conversion_attribute:  ${it.key} = ${it.value}")
                    }
                }
            }

            override fun onConversionDataFail(error: String?) {
                Log.e(AppsFlyerLibCore.LOG_TAG, "error onAttributionFailure :  $error")
            }

            override fun onAppOpenAttribution(data: MutableMap<String, String>?) {
                data?.map {
                    Log.d(AppsFlyerLibCore.LOG_TAG, "onAppOpen_attribute: ${it.key} = ${it.value}")
                }
            }

            override fun onAttributionFailure(error: String?) {
                Log.e(AppsFlyerLibCore.LOG_TAG, "error onAttributionFailure :  $error")
            }
        }

        AppsFlyerLib.getInstance().init(AF_DEV_KEY, conversionDataListener, this)
        AppsFlyerLib.getInstance().start(this)
    }

    private companion object {
        const val AF_DEV_KEY = "smUPRP4A29XgAXPEWuuYJR"
    }
}