package com.practicando.semana13.network

import com.practicando.semana13.network.response.Tractor
import retrofit2.Call
import retrofit2.http.GET

interface TractorService {
    @GET("b1e11370-653f-4ec2-b172-a2f20ad98770")
    fun getTractos() :Call<List<Tractor>>
}