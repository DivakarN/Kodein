package com.sysaxiom.kodein.util

import retrofit2.Response
import retrofit2.http.GET

interface NetworkApis {

    @GET("ping")
    suspend fun ping() : Response<PingResponse>

}