package com.igor_shaula.complex_api_client_sample.di

import com.igor_shaula.complex_api_client_sample.data.network.URL
import com.igor_shaula.complex_api_client_sample.data.network.retrofit.VehicleRetrofitNetworkService
import com.igor_shaula.complex_api_client_sample.domain.VehiclesRepository
import com.igor_shaula.complex_api_client_sample.domain.VehiclesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
//@InstallIn(SingletonComponent::class)
@InstallIn(ViewModelComponent::class)
abstract class VehiclesRepositoryModule {

    //    @Singleton
    @Binds
    abstract fun bindVehicleRepository(
        vehiclesRepositoryImpl: VehiclesRepositoryImpl
    ): VehiclesRepository
}

@Module
//@InstallIn(SingletonComponent::class)
@InstallIn(ViewModelComponent::class)
object RetrofitModule {

    //    @Singleton
    @Provides
    fun provideVehicleRetrofitNetworkService(): VehicleRetrofitNetworkService =
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VehicleRetrofitNetworkService::class.java)
}