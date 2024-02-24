package com.igor_shaula.complex_api_client_sample.data.network

// has to wrap anything that may happen during network call getVehiclesList()
data class NetworkGeneralFailure(
    val errorCode: Int = ABSENT_ERROR_CODE,
    val errorMessage: String = ABSENT_ERROR_MESSAGE,
    val initialThrowable: Throwable? = null
) : Throwable() {
    companion object {
        const val ABSENT_ERROR_CODE = -1
        const val ABSENT_ERROR_MESSAGE = ""
    }
}
