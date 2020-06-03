package com.sysaxiom.kodein.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sysaxiom.kodein.util.PingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: PingRepository
) : ViewModel() {

    fun getPing() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.ping()
            println(result)
        }
    }

}