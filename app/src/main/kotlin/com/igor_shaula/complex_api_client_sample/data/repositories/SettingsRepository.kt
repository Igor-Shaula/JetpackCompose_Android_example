package com.igor_shaula.complex_api_client_sample.data.repositories

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

    fun setChosenApi(newApi: ActiveApi)

    fun getChosenApi(): ActiveApi
}

class SettingsRepositoryImpl @Inject constructor() : SettingsRepository {

    private var selectedApi: ActiveApi = ActiveApi.OUTDOORSY // this API will be selected by default

    override fun setChosenApi(newApi: ActiveApi) {
        selectedApi = newApi
    }

    override fun getChosenApi(): ActiveApi = selectedApi
}
