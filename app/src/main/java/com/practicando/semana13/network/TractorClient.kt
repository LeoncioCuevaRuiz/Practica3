package com.practicando.semana13.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TractorClient {
    private var api: TractorService? = null
    private const val BASE_URL = "https://run.mocky.io/v3/"

    val instance: TractorService? by lazy {
        if (api == null){
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            api = retrofit.create(TractorService::class.java)
        }
        api
    }
}