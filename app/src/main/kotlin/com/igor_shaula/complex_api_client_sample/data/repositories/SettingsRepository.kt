package com.igor_shaula.complex_api_client_sample.data.repositories

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

const val OUTDOORSY_UI_NAME = "Outdoorsy"
const val BEER_UI_NAME = "Beer"

enum class ActiveApi(val uiName: String) {

    OUTDOORSY(OUTDOORSY_UI_NAME), BEER(BEER_UI_NAME);

    companion object {
        fun fromName(newApi: String) = requireNotNull(entries.find { it.uiName == newApi }) { BEER }
    }
}

interface SettingsRepository {

    val activeApiFlow: StateFlow<ActiveApi>

    fun setActiveApi(newApi: ActiveApi)
}

class SettingsRepositoryImpl @Inject constructor() : SettingsRepository {

    private val _activeApi = MutableStateFlow(ActiveApi.BEER)
    override val activeApiFlow: StateFlow<ActiveApi> = _activeApi.asStateFlow()

    override fun setActiveApi(newApi: ActiveApi) {
        _activeApi.value = newApi
//        _activeApi.emit(newApi) // the same as previous but requires to be inside a coroutine scope
    }
}
