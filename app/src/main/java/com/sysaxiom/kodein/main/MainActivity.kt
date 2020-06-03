package com.sysaxiom.kodein.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.sysaxiom.kodein.R
import com.sysaxiom.mvvmbasics.ui.room.MainViewModelFactory
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinContainer
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()

    private val factory : MainViewModelFactory by instance()

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)

        viewModel.getPing()

    }
}
