package com.igor_shaula.complex_api_client_sample.data.repositories

interface SettingsRepository {

    fun setChosenApi(newApi: ActiveApi)

    fun getChosenApi(): ActiveApi
}

enum class ActiveApi { OUTDOORSY, BEER }

class SettingsRepositoryImpl : SettingsRepository {

    private var selectedApi: ActiveApi = ActiveApi.OUTDOORSY

    override fun setChosenApi(newApi: ActiveApi) {
        selectedApi = newApi
    }

    override fun getChosenApi(): ActiveApi = selectedApi
}
