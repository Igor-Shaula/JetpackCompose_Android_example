package com.igor_shaula.complex_api_client_sample.data.network

data class NetworkGeneralFailure(val errorCode: Int, val errorMessage: String?) : Throwable()