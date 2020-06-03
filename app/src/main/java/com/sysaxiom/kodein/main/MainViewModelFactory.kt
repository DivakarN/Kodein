package com.sysaxiom.mvvmbasics.ui.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sysaxiom.kodein.main.MainViewModel
import com.sysaxiom.kodein.util.PingRepository

class MainViewModelFactory(
    private val repository: PingRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}