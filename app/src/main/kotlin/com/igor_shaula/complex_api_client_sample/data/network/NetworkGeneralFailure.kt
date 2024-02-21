package com.igor_shaula.complex_api_client_sample.data.network

data class NetworkGeneralFailure(
    val errorCode: Int = ABSENT_ERROR_CODE,
    val errorMessage: String?, // for now this one is decided to be the only mandatory field
    val initialThrowable: Throwable? = null
) : Throwable() {
    companion object {
        const val ABSENT_ERROR_CODE = -1
    }
}
