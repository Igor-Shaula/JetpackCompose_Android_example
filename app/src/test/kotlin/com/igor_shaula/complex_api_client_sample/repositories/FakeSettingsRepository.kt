package com.igor_shaula.complex_api_client_sample.repositories

import androidx.lifecycle.MediatorLiveData
import com.igor_shaula.complex_api_client_sample.data.repositories.ActiveApi
import com.igor_shaula.complex_api_client_sample.data.repositories.SettingsRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

class FakeSettingsRepository(private val activeApi: ActiveApi = ActiveApi.OUTDOORSY) : SettingsRepository {

    override val activeApiStateFlow: StateFlow<ActiveApi>
        get() = MutableStateFlow(activeApi).asStateFlow()
    override val activeApiSharedFlow: SharedFlow<ActiveApi>
        get() = MutableStateFlow(activeApi).asSharedFlow()
    override val activeApiChannel: Channel<ActiveApi>
        get() = Channel(capacity = 1)
    override val activeApiMLD: MediatorLiveData<ActiveApi>
        get() = MediatorLiveData(activeApi)

    override fun setActiveApi(newApi: ActiveApi) {
        // nothing needed here for tests
    }
}