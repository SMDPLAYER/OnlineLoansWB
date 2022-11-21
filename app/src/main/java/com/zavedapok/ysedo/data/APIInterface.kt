package com.zavedapok.ysedo.data

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
val BASE_URL = "http://vsemzamy.info/"

interface APIInterface {

    @GET("piky.php")
     fun loadData(): Call<ResponseBody>
}