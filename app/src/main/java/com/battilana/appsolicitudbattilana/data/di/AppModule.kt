package com.battilana.appsolicitudbattilana.data.di

import com.battilana.appsolicitudbattilana.data.api.UsuarioApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApi(): Retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.18.13:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun getApiUsuarios(retrofit: Retrofit): UsuarioApi = retrofit.create(UsuarioApi::class.java)
}