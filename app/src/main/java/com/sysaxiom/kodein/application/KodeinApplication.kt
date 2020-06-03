package com.sysaxiom.mvvmbasics.application

import android.app.Application
import com.sysaxiom.coroutines.util.NetworkConnectionInterceptor
import com.sysaxiom.kodein.util.PingRepository
import com.sysaxiom.coroutines.util.RetrofitHandler
import com.sysaxiom.mvvmbasics.ui.room.MainViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class KodeinApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@KodeinApplication))
        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { RetrofitHandler(instance()) }
        bind() from singleton { PingRepository(instance()) }

        bind() from provider { MainViewModelFactory(instance()) }
    }

}