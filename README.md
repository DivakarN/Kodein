# Kodein

Kodein - Kotlin Dependency Injection:
-------------------------------------

Dependency Injection:
---------------------

Dependency injection separates the creation of a client's dependencies from the client's behavior, which allows program designs to be loosely coupled and to follow the dependency inversion and single responsibility principles. 

Inversion of Control:
---------------------

IoC is all about inverting the control. To explain this in layman's terms, suppose you drive a car to your work place. This means you control the car. The IoC principle suggests to invert the control, meaning that instead of driving the car yourself, you hire a cab, where another person will drive the car. Thus, this is called inversion of the control - from you to the cab driver. You don't have to drive a car yourself and you can let the driver do the driving so that you can focus on your main work.

The IoC principle helps in designing loosely coupled classes which make them testable, maintainable and extensible.

What can you inject?
--------------------

1) Business managers
2) Presenters, Controllers, ViewModels
3) Repositories
4) OS services
5) Anything that can be abstracted!(or not)

DI in Kotlin:
-------------

1) Semantic (simple declarative DSL)
2) Idiomatic(best use of the kotlin language)
3) Easy(to use & bootstrap)
4) Android friendly
5) Java friendly(for legacy code)
6) iOS friendly(via Kotlin-Native)

Semantic:
---------
simple declarative binding DSL
Easy to understand

override val kodein = Kodein.lazy {
    import(androidXModule(this@KodeinApplication))
    bind() from singleton { NetworkConnectionInterceptor(instance()) } //infix functions
    bind() from singleton { RetrofitHandler(instance()) }
    bind() from singleton { PingRepository(instance()) }
    bind() from provider { MainViewModelFactory(instance()) }
}

Provider:
---------

Provider is a function and it will be called each time you need an instance

bind() from provider { MainViewModelFactory(instance()) }

Singleton:
----------

Singleton is a function and it will be called only one time you need an instance (gives single instance). Its thread safe.

bind() from singleton { PingRepository(instance()) }

Instance:
---------

Instance is a function gives instance if it already instantiated previously.

bind() from singleton { RetrofitHandler(instance()) }

Factory Bindings:
-----------------

//It will be called each time you need an instance with passing an arguments to the instance.
bind() from factory { sides: Int -> NetworkHandling(sides) }

//Its like a singleton , If we are calling a function with same arguments twice then it will gives single instance. If it is different arguments then it willbe called each time you need an instance.
bind() from multiton { sides: Int -> NetworkHandling(sides) }


Transitive Dependencies:
------------------------

Transitive Dependencies are dependencies of dependencies.
Because of reinfied generics, compiler will understand the instance object.

bind() from singleton { NetworkConnectionInterceptor(instance()) }
bind() from singleton { RetrofitHandler(instance()) }

Kodein Modules:
---------------

We can create multiple modules and work independently in kodein

val apiModule = Kodein.Module {
	bind() from singleton { NetworkConnectionInterceptor(instance()) }
	bind() from singleton { RetrofitHandler(instance()) }
}

override val kodein = Kodein.lazy {
    import(apiModule)
}

Idiomatic:
----------

best use of kotlin language

class MyManager(val kodein: Kodein){
	val networkConnectionInterceptor : NetworkConnectionInterceptor = kodein.instance()
	val retrofitHandler : RetrofitHandler = kodein.provider()
}

KodeinAware:
------------

It's a simple interface, which makes class/components should be aware of kodein instances.

Advantages:
-----------

1) Lazy initialization
2) Receiver aware
3) Readability
