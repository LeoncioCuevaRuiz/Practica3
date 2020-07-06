package com.practicando.semana13.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.practicando.semana13.network.response.Tractor
import com.practicando.semana13.repository.TractorRepository

class Tractorsviewmodel (application: Application):AndroidViewModel(application) {

    private val tractorRepository:TractorRepository

    init {
        tractorRepository = TractorRepository()
    }

    fun getTractors():LiveData<List<Tractor>>{
        return tractorRepository.getTractors()
    }
}