package com.practicando.semana13.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.practicando.semana13.R
import com.practicando.semana13.viewmodel.Tractorsviewmodel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val tractorViewModel by lazy { ViewModelProvider(this).get(Tractorsviewmodel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter =TractorsAdapter(this)
        rvtractor.adapter=adapter
        rvtractor.layoutManager = LinearLayoutManager(this)

        tractorViewModel.getTractors().observe(this, Observer {
            it?.let { adapter.setTractors(it) }
        })
    }
}