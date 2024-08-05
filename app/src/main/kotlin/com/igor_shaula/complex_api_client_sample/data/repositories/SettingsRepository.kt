package com.igor_shaula.complex_api_client_sample.data.repositories

import androidx.lifecycle.MediatorLiveData
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

const val GOOGLE_BOOKS_V1_UI_NAME = "Google Books v1"

// this API is initial but
const val OUTDOORSY_UI_NAME = "Outdoorsy"

// at the moment this case is not connected as it requires
const val BEER_UI_NAME = "Beer"

enum class ActiveApi(val uiName: String) {

    GOOGLE_BOOKS_V1(GOOGLE_BOOKS_V1_UI_NAME), OUTDOORSY(OUTDOORSY_UI_NAME), BEER(BEER_UI_NAME);

    companion object {
        fun fromName(newApi: String) = requireNotNull(entries.find { it.uiName == newApi })
        fun default() = BEER // the only place of real setting of preselected API
    }
}

interface SettingsRepository {

    val activeApiStateFlow: StateFlow<ActiveApi>

    // all other vals are just an experiment for comparison - every of these approaches work
    val activeApiSharedFlow: SharedFlow<ActiveApi>
    val activeApiChannel: Channel<ActiveApi>
    val activeApiMLD: MediatorLiveData<ActiveApi>

    fun setActiveApi(newApi: ActiveApi)
}

// decided to have it as a singleton to avoid issues with different instances and scoped injections
object SettingsRepositoryImpl : SettingsRepository {

    private val _activeApi = MutableStateFlow(ActiveApi.BEER)
    override val activeApiStateFlow: StateFlow<ActiveApi> = _activeApi.asStateFlow()

    override val activeApiSharedFlow: SharedFlow<ActiveApi> = _activeApi.asSharedFlow()
    override val activeApiChannel: Channel<ActiveApi> = Channel(capacity = 1)
    override val activeApiMLD = MediatorLiveData(ActiveApi.BEER)

    override fun setActiveApi(newApi: ActiveApi) {
        _activeApi.value = newApi // the only needed payload in fact - later i'll remove the rest
//        _activeApi.emit(newApi) // the same as previous but requires to be inside a coroutine scope
        println("setActiveApi: _activeApi.value = ${_activeApi.value} ")
        println("setActiveApi: activeApiStateFlow.value = ${activeApiStateFlow.value} ")
        println("setActiveApi: activeApiSharedFlow.value = ${activeApiSharedFlow.replayCache} ")
        activeApiMLD.value = newApi
        println("setActiveApi: activeApiMLD.value = ${activeApiMLD.value} ")
    }
}
