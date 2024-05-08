package com.igor_shaula.complex_api_client_sample

import com.igor_shaula.complex_api_client_sample.data.network.OUTDOORSY_BASE_URL
import com.igor_shaula.complex_api_client_sample.data.network.retrofit.VehicleRetrofitNetworkService
import com.igor_shaula.complex_api_client_sample.data.repositories.SettingsRepository
import com.igor_shaula.complex_api_client_sample.data.repositories.SettingsRepositoryImpl
import com.igor_shaula.complex_api_client_sample.data.repositories.VehiclesRepository
import com.igor_shaula.complex_api_client_sample.data.repositories.VehiclesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @ViewModelScoped
    @Binds
    fun bindSettingsRepository(
        settingsRepositoryImpl: SettingsRepositoryImpl
    ): SettingsRepository

    @ViewModelScoped
    @Binds
    fun bindVehicleRepository(
        vehiclesRepositoryImpl: VehiclesRepositoryImpl
    ): VehiclesRepository

    // this variant also works but i decided to rely on binding as it's simpler & allows "interface"
//    @ViewModelScoped
//    @Provides // no need - as creation of VehiclesRepositoryImpl instance is described in its constructor
//    fun provideVehicleRepository( // this would require to convert this class into interface
//        networkDataSource: NetworkDataSource,
//        fakeDataSource: FakeDataSource
//    ): VehiclesRepository = VehiclesRepositoryImpl(networkDataSource, fakeDataSource)
}

@Module
@InstallIn(ViewModelComponent::class)
object RetrofitModule {

    @ViewModelScoped
    @Provides
    fun provideVehicleRetrofitNetworkService(): VehicleRetrofitNetworkService =
        Retrofit.Builder()
            .baseUrl(OUTDOORSY_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VehicleRetrofitNetworkService::class.java)
}
