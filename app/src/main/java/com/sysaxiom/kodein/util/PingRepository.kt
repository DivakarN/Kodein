package com.sysaxiom.kodein.util

import com.sysaxiom.coroutines.util.SafeApiRequest

class PingRepository (val networkApis: NetworkApis) : SafeApiRequest() {

    suspend fun ping(): PingResponse {
        return apiRequest { networkApis.ping() }
    }
}