package com.igor_shaula.complex_api_client_sample.repositories

import androidx.lifecycle.MediatorLiveData
import com.igor_shaula.complex_api_client_sample.data.repositories.ActiveApi
import com.igor_shaula.complex_api_client_sample.data.repositories.SettingsRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

object FakeSettingsRepository : SettingsRepository {

    override val activeApiStateFlow: StateFlow<ActiveApi>
        get() = TODO("Not yet implemented")
    override val activeApiSharedFlow: SharedFlow<ActiveApi>
        get() = TODO("Not yet implemented")
    override val activeApiChannel: Channel<ActiveApi>
        get() = TODO("Not yet implemented")
    override val activeApiMLD: MediatorLiveData<ActiveApi>
        get() = TODO("Not yet implemented")

    override fun setActiveApi(newApi: ActiveApi) {
        TODO("Not yet implemented")
    }
}