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

object FakeSettingsRepository : SettingsRepository {

    override val activeApiStateFlow: StateFlow<ActiveApi>
        get() = MutableStateFlow(ActiveApi.default()).asStateFlow()
    override val activeApiSharedFlow: SharedFlow<ActiveApi>
        get() = MutableStateFlow(ActiveApi.default()).asSharedFlow()
    override val activeApiChannel: Channel<ActiveApi>
        get() = Channel(capacity = 1)
    override val activeApiMLD: MediatorLiveData<ActiveApi>
        get() = MediatorLiveData(ActiveApi.default())

    override fun setActiveApi(newApi: ActiveApi) {
        // nothing needed here for tests
    }
}