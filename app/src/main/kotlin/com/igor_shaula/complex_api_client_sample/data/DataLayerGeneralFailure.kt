package com.igor_shaula.complex_api_client_sample.data

import com.igor_shaula.complex_api_client_sample.data.network.NetworkGeneralFailure

data class DataLayerGeneralFailure(val explanation: String? = null) : Throwable()

internal fun NetworkGeneralFailure.prepareExplanation(): String {
    val explanation = StringBuilder()
    if (this.initialThrowable != null) {
        explanation.append(initialThrowable.javaClass.name + "\n" + initialThrowable.message)
        return explanation.toString()
    }
    explanation.append("NetworkGeneralFailure:\n")
    if (this.errorCode != NetworkGeneralFailure.ABSENT_ERROR_CODE) {
        explanation.append("errorCode: $errorCode\n")
    }
    if (this.errorMessage != NetworkGeneralFailure.ABSENT_ERROR_MESSAGE) {
        explanation.append("errorMessage: $errorMessage\n")
    }
    return explanation.toString()
}
