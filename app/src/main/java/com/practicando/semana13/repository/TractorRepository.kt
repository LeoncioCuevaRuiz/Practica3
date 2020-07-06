package com.practicando.semana13.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.practicando.semana13.network.TractorClient
import com.practicando.semana13.network.response.Tractor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TractorRepository {
    private lateinit var tractors: MutableLiveData<List<Tractor>>

    fun getTractors(): LiveData<List<Tractor>> {
        tractors = MutableLiveData()
        val call: Call<List<Tractor>> = TractorClient.instance!!.getTractos()
        call.enqueue(object : Callback<List<Tractor>> {
            override fun onResponse(call: Call<List<Tractor>>, response: Response<List<Tractor>>) {
                if(response.isSuccessful){
                    tractors.value = response.body()
                    Log.i("tractors","datos correctos")
                }
                else
                    Log.e("tractors","error al obtener los datos")
            }
            override fun onFailure(call: Call<List<Tractor>>, t: Throwable) {
                Log.e("tractors", "falla la conexion")
            }

        })
        return tractors
    }
}