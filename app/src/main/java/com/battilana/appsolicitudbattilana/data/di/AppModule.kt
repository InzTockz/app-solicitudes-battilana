package com.battilana.appsolicitudbattilana.data.di

import com.battilana.appsolicitudbattilana.data.api.UsuarioApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApi(): Retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.139:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun getListado(retrofit: Retrofit): UsuarioApi = retrofit.create(UsuarioApi::class.java)
}