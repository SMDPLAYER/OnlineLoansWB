package com.zavedapok.ysedo.start

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.zavedapok.ysedo.R
import com.facebook.FacebookSdk
import com.facebook.applinks.AppLinkData
import com.zavedapok.ysedo.data.NetworkModule
import com.zavedapok.ysedo.data.Prefs
import com.zavedapok.ysedo.exclusive.ExclusiveContentActivity
import com.zavedapok.ysedo.loanseu.MainActivity
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.UnknownHostException

val EXTRA_TASK_URL = "extra_task_url"

class ThinkActivity : AppCompatActivity() {

    private var queryString = ""
    lateinit var pref: Prefs
    private val progressBar: View by lazy { findViewById(R.id.progress_bar) }
    private val noInternet: View by lazy { findViewById(R.id.no_internet_container) }
    private val retryBtn: Button by lazy { findViewById(R.id.reload_btn) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash1)
        Prefs.init(this)
        pref = Prefs
        supportActionBar?.hide()

        initListeners()
//        runOnUiThread { loadData() }
        initFb()
    }

    private fun initListeners() {
        retryBtn.setOnClickListener { loadData() }
    }

    private fun initFb() {
        FacebookSdk.setAutoInitEnabled(true)
        FacebookSdk.fullyInitialize()
        loadFbDeepLink()
    }

    private fun loadFbDeepLink() {
        AppLinkData.fetchDeferredAppLinkData(this) {
            fetchLinkData(it?.targetUri?.toString())
        }
    }

    private fun fetchLinkData(link: String?) {
        if (link == null) {
            runOnUiThread { loadData() }
            return
        }
        val data = link.split("//")
        queryString = data[1]
        runOnUiThread { loadData() }
    }

    private fun loadData() {
        var afid: String = ""
        try {
            afid = com.appsflyer.AppsFlyerLib.getInstance().getAppsFlyerUID(applicationContext)
        } catch (e: Exception) {
            //do nothing
        }
        progressBar.isVisible = true
        noInternet.isVisible = false

        NetworkModule.utilService.loadData().enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                progressBar.isVisible = false
                if (response.isSuccessful) {
                    val body = response.body()?.string() ?: "0"
                    if (body != "0") {
                        when {
                            queryString != "" -> {
                                if (queryString.startsWith("?")) {
                                    queryString = queryString.substring(1)
                                }
                                val url = if (body.contains("?")) {
                                    "$body&$queryString&afid=$afid"
                                } else {
                                    "$body?$queryString&afid=$afid"
                                }
                                startActivity(
                                    Intent(
                                        this@ThinkActivity,
                                        ExclusiveContentActivity::class.java
                                    )
                                        .putExtra(EXTRA_TASK_URL, url)
                                )
                                finish()
                            }
                            Prefs.url != "" -> {
                                startActivity(
                                    Intent(
                                        this@ThinkActivity,
                                        ExclusiveContentActivity::class.java
                                    )
                                        .putExtra(EXTRA_TASK_URL, Prefs.url)
                                )
                                finish()
                            }
                            else -> {
                                val url = if (body.contains("?")) {
                                    "$body&$queryString&afid=$afid"
                                } else {
                                    "$body?$queryString&afid=$afid"
                                }
                                startActivity(
                                    Intent(
                                        this@ThinkActivity,
                                        ExclusiveContentActivity::class.java
                                    )
                                        .putExtra(EXTRA_TASK_URL, url)
                                )
                                finish()
                            }
                        }
                    } else {
//                        toast("4")
                        startActivity(Intent(this@ThinkActivity, MainActivity::class.java))
                        finish()
                    }
                } else {
                    noInternet.isVisible = true
//                    toast("3")
                    startActivity(Intent(this@ThinkActivity, MainActivity::class.java))
                    finish()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                if (t is UnknownHostException) {
//                    toast("2")
                    startActivity(
                        Intent(
                            this@ThinkActivity,
                            MainActivity::class.java
                        )
                    )
                    finish()
                } else {
                    progressBar.isVisible = false
                    noInternet.isVisible = true
//                    toast("1")
                    startActivity(Intent(this@ThinkActivity, MainActivity::class.java))
                    finish()
                }
            }
        })
    }
}